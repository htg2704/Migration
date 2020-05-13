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
import android.util.Log;
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

import java.io.File;

public class bulk_data extends AppCompatActivity {

    CardView down;
    CardView upload;
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
                download();
            }
        });

        upload = findViewById(R.id.upload);
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                upload();
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

    private void upload() {

    }


    public void download(){

        storageReference=FirebaseStorage.getInstance().getReference();
        ref=storageReference.child("Bulkdataformat.xlsm");
        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String url = uri.toString();
                Toast.makeText(bulk_data.this,"URL RECEIEVED",Toast.LENGTH_SHORT).show();
                downloadFile(uri);

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(bulk_data.this,"Some error occured",Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void downloadFile(Uri uri) {
        File file = new File(Environment.getExternalStorageDirectory(),"Bulkdataformat.xlsm");
        DownloadManager downloadManager = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
        DownloadManager.Request request = new DownloadManager.Request(uri).setTitle("File download")
                .setDescription("This is BULK DATA FORMAT")
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
                .setDestinationUri(Uri.fromFile(file));

        downloadManager.enqueue(request);
    }


    @Override
    public void onBackPressed() {

        finish();
        Intent intent = new Intent(bulk_data.this, after_login.class);
        startActivity(intent);
    }

}