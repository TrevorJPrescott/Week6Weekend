package com.trevorpc.myapplication;

import android.media.MediaRouter;
import android.support.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FirebaseDataManager {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference simpleReference;
    private final DatabaseReference userReference;


    public FirebaseDataManager() {
        firebaseDatabase = FirebaseDatabase.getInstance();
        simpleReference = firebaseDatabase.getReference("simpleData");
        userReference = firebaseDatabase.getReference("user");

    }

    public void postUser()
    {
        simpleReference.child("simple").setValue("Hello, World!");


    }
}




