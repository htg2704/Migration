package com.example.migration.Register;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import io.grpc.Context;

import android.app.DownloadManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.migration.MainActivity;
import com.example.migration.R;
import com.example.migration.after_login;
import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class bulk_data extends AppCompatActivity {

    CardView down,up;
    ImageButton btn;
    FirebaseStorage firebaseStorage;
    StorageReference storageReference;
    StorageReference ref;
    private long backPressedTime = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bulk_data);

        down = findViewById(R.id.download);
        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(bulk_data.this, "Download Started", Toast.LENGTH_SHORT).show();
                download();
                Toast.makeText(bulk_data.this, "Download Successful", Toast.LENGTH_SHORT).show();
            }
        });

        up = findViewById(R.id.upload);
        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertadd = new AlertDialog.Builder(bulk_data.this);
                LayoutInflater factory = LayoutInflater.from(bulk_data.this);
                v = factory.inflate(R.layout.sample, null);
                alertadd.setView(v);
                alertadd.show();
                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {

                        Intent intent = new Intent(bulk_data.this, upload.class);
                        startActivity(intent);
                    }
                }, 1100);

            }
        });



        btn=findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(bulk_data.this, after_login.class);
                startActivity(intent);

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
    @Override
    public void onBackPressed() {

        finish();
        Intent intent = new Intent(bulk_data.this, after_login.class);
        startActivity(intent);
    }

}