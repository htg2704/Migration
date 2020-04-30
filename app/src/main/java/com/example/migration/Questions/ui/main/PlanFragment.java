package com.example.migration.Questions.ui.main;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.example.migration.Database.AwarenessDB;
import com.example.migration.Database.MigrationDB;
import com.example.migration.Database.MyDB;
import com.example.migration.Database.PlanDB;
import com.example.migration.Questions.questions;
import com.example.migration.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import static android.content.ContentValues.TAG;

public class PlanFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";


    public static PlanFragment newInstance(int index) {
        PlanFragment fragment = new PlanFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        final PlanDB planDB = new PlanDB(getActivity().getApplicationContext());
        final MigrationDB migrationDB = new MigrationDB(getActivity().getApplicationContext());
        final MyDB myDB = new MyDB(getActivity().getApplicationContext());
        final AwarenessDB awarenessDB = new AwarenessDB(getActivity().getApplicationContext());

        final View root = inflater.inflate(R.layout.fragment_plan, container, false);

        final Spinner support_after = (Spinner) root.findViewById(R.id.lockdown_support_spinner);
        ArrayAdapter<CharSequence> support_after_adapter = ArrayAdapter.createFromResource(getContext(), R.array.work_array, android.R.layout.simple_spinner_item);
        support_after_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        support_after.setAdapter(support_after_adapter);
        final Spinner skill_spinner = (Spinner) root.findViewById(R.id.skill_upgrade_spinner);
        ArrayAdapter<CharSequence> skill_adapter = ArrayAdapter.createFromResource(getContext(), R.array.interest_array, android.R.layout.simple_spinner_item);
        skill_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        skill_spinner.setAdapter(skill_adapter);
        final Spinner live_spinner = (Spinner) root.findViewById(R.id.livelihhod_spinner);
        ArrayAdapter<CharSequence> live_adapter = ArrayAdapter.createFromResource(getContext(), R.array.cur_options_array, android.R.layout.simple_spinner_item);
        live_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        live_spinner.setAdapter(live_adapter);
        final Spinner training_spinner = (Spinner) root.findViewById(R.id.training_spinner);
        ArrayAdapter<CharSequence> training_adapter = ArrayAdapter.createFromResource(getContext(), R.array.train_array, android.R.layout.simple_spinner_item);
        training_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        training_spinner.setAdapter(training_adapter);

        final Button save = root.findViewById(R.id.save_plan);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Cursor personal, migration, plan, awareness;

                Switch where, skill, safety, onestop, housing, health, school, distant;

                String where_for_job, skill_need, support_lockdown, safety_net, one_stop, distant_work, affordable_housing, healthcare, schooling, skill_upgrade,
                        availability_for_training, present_livelihood;

                where = root.findViewById(R.id.where_to_go_switch);
                skill = root.findViewById(R.id.skill_switch);
                safety = root.findViewById(R.id.safety_switch);
                onestop = root.findViewById(R.id.one_stop_switch);
                housing = root.findViewById(R.id.housing_switch);
                health = root.findViewById(R.id.healthcare_switch);
                school = root.findViewById(R.id.school_switch);
                distant = root.findViewById(R.id.distant_switch);


                support_lockdown = support_after.getSelectedItem().toString();
                skill_upgrade = skill_spinner.getSelectedItem().toString();
                availability_for_training = training_spinner.getSelectedItem().toString();
                present_livelihood = live_spinner.getSelectedItem().toString();
                if (where.isChecked()) {
                    where_for_job = "Yes";
                } else {
                    where_for_job = "No";
                }
                if (skill.isChecked()) {
                    skill_need = "Yes";
                } else {
                    skill_need = "No";
                }
                if (safety.isChecked()) {
                    safety_net = "Yes";
                } else {
                    safety_net = "No";
                }
                if (onestop.isChecked()) {
                    one_stop = "Yes";
                } else {
                    one_stop = "No";
                }
                if (housing.isChecked()) {
                    affordable_housing = "Yes";
                } else {
                    affordable_housing = "No";
                }
                if (health.isChecked()) {
                    healthcare = "Yes";
                } else {
                    healthcare = "No";
                }
                if (school.isChecked()) {
                    schooling = "Yes";
                } else {
                    schooling = "No";
                }
                if (distant.isChecked()) {
                    distant_work = "Yes";
                } else {
                    distant_work = "No";
                }
                Log.d(TAG, "city " + where);
                planDB.addData(where_for_job, skill_need, support_lockdown, safety_net, one_stop, distant_work, affordable_housing,
                        healthcare, schooling, skill_upgrade, availability_for_training, present_livelihood);

                where.setChecked(false);
                onestop.setChecked(false);
                housing.setChecked(false);
                health.setChecked(false);
                school.setChecked(false);
                distant.setChecked(false);
                safety.setChecked(false);
                skill.setChecked(false);

                personal = myDB.getLastData();
                migration = migrationDB.getLastData();
                awareness = awarenessDB.getLastData();
                plan = planDB.getLastData();


                FirebaseFirestore db = FirebaseFirestore.getInstance();
                Map<String, Object> migrant = new HashMap<>();

               if (personal.moveToFirst()) {


                    int idIdx = personal.getColumnIndex("ID");
                    int nameIdx = personal.getColumnIndex("Name");
                    int ageIdx = personal.getColumnIndex("Age");
                    int genderIdx = personal.getColumnIndex("gender");
                    int casteIdx = personal.getColumnIndex("caste");
                    int pwdIdx = personal.getColumnIndex("Pwd");
                    int eduIdx = personal.getColumnIndex("education");
                    int pinIdx = personal.getColumnIndex("pin");
                    int mobIdx = personal.getColumnIndex("Mobile");
                    int cityIdx = personal.getColumnIndex("city");
                    int govtIdx = personal.getColumnIndex("govt_id");
                    int dependentsIdx = personal.getColumnIndex("dependents");


                    //int id = personal.getInt(idIdx);
                    String name = personal.getString(nameIdx);
                    String age = personal.getString(ageIdx);
                    String gender = personal.getString(genderIdx);
                    String caste = personal.getString(casteIdx);
                    String pwd = personal.getString(pwdIdx);
                    String education = personal.getString(eduIdx);
                    Double pin = personal.getDouble(pinIdx);
                    Double mob = personal.getDouble(mobIdx);
                    String city = personal.getString(cityIdx);
                    String govt_id = personal.getString(govtIdx);
                    String dependants = personal.getString(dependentsIdx);

                    migrant.put("Name", name);
                    migrant.put("Age", age);
                    migrant.put("Gender", gender);
                    migrant.put("Caste", caste);
                    migrant.put("Education", education);
                    migrant.put("PWD", pwd);
                    migrant.put("Pin", pin);
                    migrant.put("Mobile", mob);
                    migrant.put("City", city);
                    migrant.put("Govt_id", govt_id);
                    migrant.put("Dependants", dependants);

                }

                if (migration.moveToFirst()) {

                  //  int idIdx = migration.getColumnIndex("ID");
                    int natureIdx = migration.getColumnIndex("nature");
                    int locIdx = migration.getColumnIndex("location");
                    int periodIdx = migration.getColumnIndex("period");
                    int wageIdx = migration.getColumnIndex("wage");
                    int employerIdx = migration.getColumnIndex("employer");
                    int enoIdx = migration.getColumnIndex("e_no");
                    int obenIdx = migration.getColumnIndex("otherbenefits");
                    int chalIdx = migration.getColumnIndex("challenges");



                    //int id = personal.getInt(idIdx);
                    String nature = migration.getString(natureIdx);
                    String locn = migration.getString(locIdx);
                    String period = migration.getString(periodIdx);
                    String wage = migration.getString(wageIdx);
                    String employer = migration.getString(employerIdx);
                    double eno = migration.getDouble(enoIdx);
                    String oben = migration.getString(obenIdx);
                    String chal = migration.getString(chalIdx);


                    migrant.put("Nature", nature);
                    migrant.put("Location", locn);
                    migrant.put("Period", period);
                    migrant.put("Wage", wage);
                    migrant.put("Employer", employer);
                    migrant.put("Employee Number", eno);
                    migrant.put("Other Benefits", oben);
                    migrant.put("Challenges", chal);


                }

                 if (awareness.moveToFirst()) {

                    int gvtbenIdx = awareness.getColumnIndex("govt_ben");
                    int cvdIdx = awareness.getColumnIndex("covid_know");
                    int lock_knowIdx = awareness.getColumnIndex("lock_know");
                    int responseIdx = awareness.getColumnIndex("response");
                    int curlocIdx = awareness.getColumnIndex("current_loc");
                    int sprtrdIdx = awareness.getColumnIndex("support_received");
                    int sprtndIdx = awareness.getColumnIndex("support_needed");
                    int cvdslfIdx = awareness.getColumnIndex("covid_self");
                    int rchIdx = awareness.getColumnIndex("reach");


                    migrant.put("Govt Benefits", awareness.getString(gvtbenIdx));
                    migrant.put("Covid Knowledge", awareness.getString(cvdIdx));
                    migrant.put("Lockdown Knowledge", awareness.getString(lock_knowIdx));
                    migrant.put("Response", awareness.getString(responseIdx));
                    migrant.put("Current Location", awareness.getString(curlocIdx));
                    migrant.put("Support Received", awareness.getString(sprtrdIdx));
                    migrant.put("Support Needed", awareness.getString(sprtndIdx));
                    migrant.put("Covid Self", awareness.getString(cvdslfIdx));
                    migrant.put("Reach", awareness.getString(rchIdx));

               }

                if (plan.moveToFirst()) {


                    migrant.put("Where for Job", plan.getString(plan.getColumnIndex("where_for_job")));
                    migrant.put("Skill Need", plan.getString(plan.getColumnIndex("skil_need")));
                    migrant.put("Support Lockdown", plan.getString(plan.getColumnIndex("support_lockdown")));
                    migrant.put("Safety Net", plan.getString(plan.getColumnIndex("safety_net")));
                    migrant.put("One Stop", plan.getString(plan.getColumnIndex("one_stop")));
                    migrant.put("Distant Work", plan.getString(plan.getColumnIndex("distant_work")));
                    migrant.put("Affordable Housing", plan.getString(plan.getColumnIndex("affordable_housing")));
                    migrant.put("Health Care", plan.getString(plan.getColumnIndex("healthcare")));
                    migrant.put("Schooling", plan.getString(plan.getColumnIndex("schooling")));
                    migrant.put("Skill Upgrade", plan.getString(plan.getColumnIndex("skill_upgrade")));
                    migrant.put("Availability for Training ", plan.getString(plan.getColumnIndex("availability_for_training")));
                    migrant.put("Present Livelihood", plan.getString(plan.getColumnIndex("present_livelihood")));
               }


                db.collection("Migrants")
                        .add(migrant)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                ((questions)getActivity()).selectTab(0);//Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                //Log.w(TAG, "Error adding document", e);
                            }
                        });

                Toast.makeText(getActivity(),"Data added successfully, you can add more",Toast.LENGTH_SHORT).show();
                save.setEnabled(false);


            }
        });
        return root;
    }

}
