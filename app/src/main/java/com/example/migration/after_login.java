package com.example.migration;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.migration.Questions.questions;
import com.example.migration.Register.LoginOrRegister;
import com.example.migration.Register.select_login_type;
import com.example.migration.common.User;
import com.facebook.AccessToken;
import com.facebook.login.LoginManager;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class after_login extends AppCompatActivity {

    CardView enter_register,enter_data,down,up;
    ProgressDialog dialog;
    Button buttonChoose;
    Button buttonUpload;
    ImageButton logout,btn;
    FirebaseStorage firebaseStorage;
    StorageReference storageReference;
    StorageReference ref;
    Uri filePath;
    private long backPressedTime = 0;
    GoogleSignInClient mGoogleSignInClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_login);


        enter_register = findViewById(R.id.btn_register);
        enter_data = findViewById(R.id.bulk);
        logout = findViewById(R.id.btn_logout);
        down = findViewById(R.id.download);
        down.setVisibility(View.GONE);
        up = findViewById(R.id.upload);
        up.setVisibility(View.GONE);
        buttonChoose = findViewById(R.id.buttonChoose);
        buttonChoose.setVisibility(View.GONE);
        buttonUpload = findViewById(R.id.buttonUpload);
        buttonUpload.setVisibility(View.GONE);

        enter_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertadd = new AlertDialog.Builder(after_login.this);
                LayoutInflater factory = LayoutInflater.from(after_login.this);
                view = factory.inflate(R.layout.sample, null);
                alertadd.setView(view);
                alertadd.show();
                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {

                        Intent intent = new Intent(getApplicationContext(), questions.class);
                        startActivity(intent);
                    }
                }, 1100);
            }
        });

        enter_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                down.setVisibility(View.VISIBLE);
                up.setVisibility(View.VISIBLE);

            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(User.type!=1) {
                    FirebaseAuth.getInstance().signOut();
                    AccessToken accessToken = AccessToken.getCurrentAccessToken();
                    boolean isLoggedIn = accessToken != null && !accessToken.isExpired();

                    if (isLoggedIn)
                        LoginManager.getInstance().logOut();

                    GoogleSignInOptions gso = new GoogleSignInOptions.Builder(com.google.android.gms.auth.api.signin.GoogleSignInOptions.DEFAULT_SIGN_IN).
                            requestIdToken(getString(R.string.default_g_web_client_id))
                            .requestEmail()
                            .build();
                    mGoogleSignInClient= GoogleSignIn.getClient(after_login.this, gso);
                    GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(after_login.this);
                    if (account != null) {
                        mGoogleSignInClient.signOut()
                                .addOnCompleteListener(after_login.this, new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@androidx.annotation.NonNull Task<Void> task) {
                                        // ...
                                        Toast.makeText(after_login.this,"Google Signed Out",Toast.LENGTH_LONG);
                                    }
                                });

                    }
                }

                AlertDialog.Builder dialog = new AlertDialog.Builder(after_login.this);
                dialog.setTitle("Alert !");
                dialog.setMessage("Are you sure you want to Logout ?");
                dialog.setCancelable(true);

                dialog.setPositiveButton(
                        "Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int
                                    id) {
                                Intent intent = new Intent(getApplicationContext(),User.type==1? select_login_type.class : LoginOrRegister.class);
                                startActivity(intent);


                                finish();

                            }
                        });

                dialog.setNegativeButton(
                        "No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert = dialog.create();
                alert.show();
            }

        });

        btn=findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(after_login.this, select_login_type.class);
                startActivity(intent);

            }
        });

        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(after_login.this, "Download Started", Toast.LENGTH_SHORT).show();
                download();
                Toast.makeText(after_login.this, "Download Successful", Toast.LENGTH_SHORT).show();
            }
        });


        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonChoose.setVisibility(View.VISIBLE);

            }
        });


        storageReference = FirebaseStorage.getInstance().getReference();
        buttonChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFileChooser();
                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {

                        buttonUpload.setVisibility(View.VISIBLE);
                    }
                }, 1000);

            }
        });
        buttonUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadFile();
            }
        });

    }

    public void download(){
        storageReference=firebaseStorage.getInstance().getReference();
        ref=storageReference.child("Bulkdataformat.xlsm");

        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String url = uri.toString();
                downloadFile("Bulkdataformat",".xlsm", Environment.DIRECTORY_DOWNLOADS,url);

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });
    }

    public void downloadFile(String fileName,String fileExtension,String destinationDirectory,String url){
        DownloadManager downloadManager = (DownloadManager) getApplicationContext().getSystemService(getApplicationContext().DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(url);
        DownloadManager.Request request = new DownloadManager.Request(uri);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalFilesDir(getApplicationContext(),destinationDirectory,fileName + fileExtension);
        downloadManager.enqueue(request);
    }

    private void showFileChooser() {
        Intent intent = new Intent();
        intent.setType("*/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Bulk Data(EXCEL) File"),1 );
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            filePath = data.getData();
            Toast.makeText(getApplicationContext(), "Bulk Data(Excel)File Selected Successfully ", Toast.LENGTH_LONG).show();

        }
    }

    private void uploadFile() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Uploading");
        progressDialog.show();

        StorageReference riversRef = storageReference.child(System.currentTimeMillis()+".xlsm");
        riversRef.putFile(filePath)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        progressDialog.dismiss();

                        //and displaying a success toast
                        Toast.makeText(getApplicationContext(), "Bulk Data(Excel) File Uploaded\nThank you for your Contribution", Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        progressDialog.dismiss();

                        Toast.makeText(getApplicationContext(), exception.getMessage(), Toast.LENGTH_LONG).show();
                    }
                })
                .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                        double progress = (100.0 * taskSnapshot.getBytesTransferred()) / taskSnapshot.getTotalByteCount();

                        progressDialog.setMessage("Uploaded " + ((int) progress) + "%...");
                    }
                });

    }

    @Override
    public void onBackPressed() {

            AlertDialog.Builder dialog = new AlertDialog.Builder(after_login.this);
            dialog.setTitle("Alert !");
            dialog.setMessage("Are you sure you want to exit ?");
            dialog.setCancelable(true);

            dialog.setPositiveButton(
                    "Yes",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int
                                id) {
                            finish();
                            Intent intent = new Intent(after_login.this, select_login_type.class);
                            startActivity(intent);

                        }
                    });

            dialog.setNegativeButton(
                    "No",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });

            AlertDialog alert = dialog.create();
            alert.show();

    }
}
