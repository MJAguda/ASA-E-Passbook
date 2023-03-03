package com.example.asae_passbook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

public class BranchActivity extends AppCompatActivity {

    Branch branch = Branch.getInstance();
    Read read = new Read();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_branch);

        // Declare EditText
        EditText branchId = findViewById(R.id.branchId_EditText);

        // Declare Button
        Button submit = findViewById(R.id.submit_Button);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                branch.setBranchId(branchId.getText().toString());

                // Read Branch ID
                read.readRecord(branch.getBranchId() + "/", new Read.OnGetDataListener() {
                    @Override
                    public void onSuccess(DataSnapshot dataSnapshot) {
                        if(!dataSnapshot.exists()){
                            Toast.makeText(getApplicationContext(), "Branch Not Found", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(getApplicationContext(), "Branch Not Exists", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(DatabaseError databaseError) {
                        Toast.makeText(getApplicationContext(), "Read Error", Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });

    }
}

// TODO add ADMIN Screen
// TODO add Branch Manager Screen
// TODO add MFO Screen
// TODO add Client Screen