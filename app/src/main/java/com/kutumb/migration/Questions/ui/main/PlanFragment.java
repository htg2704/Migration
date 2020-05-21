package com.kutumb.migration.Questions.ui.main;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.kutumb.migration.Database.AwarenessDB;
import com.kutumb.migration.Database.MigrationDB;
import com.kutumb.migration.Database.MyDB;
import com.kutumb.migration.Database.PlanDB;
import com.kutumb.migration.Questions.questions;
import com.kutumb.migration.R;
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
        final ArrayAdapter<CharSequence> live_adapter = ArrayAdapter.createFromResource(getContext(), R.array.cur_options_array, android.R.layout.simple_spinner_item);
        live_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        live_spinner.setAdapter(live_adapter);
        final Spinner training_spinner = (Spinner) root.findViewById(R.id.training_spinner);
        ArrayAdapter<CharSequence> training_adapter = ArrayAdapter.createFromResource(getContext(), R.array.train_array, android.R.layout.simple_spinner_item);
        training_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        training_spinner.setAdapter(training_adapter);
        final Spinner plan_spinner = (Spinner) root.findViewById(R.id.migrateplan);
        final ArrayAdapter<CharSequence> plan_adapter = ArrayAdapter.createFromResource(getContext(), R.array.migrate_plan_array, android.R.layout.simple_spinner_item);
        plan_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        plan_spinner.setAdapter(plan_adapter);
        final Spinner support_spinner = (Spinner) root.findViewById(R.id.migratesupport);
        ArrayAdapter<CharSequence> support_adapter = ArrayAdapter.createFromResource(getContext(), R.array.migrate_support_array, android.R.layout.simple_spinner_item);
        support_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        support_spinner.setAdapter(support_adapter);

        final Button save = root.findViewById(R.id.save_plan);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Cursor personal, migration, plan, awareness;

                EditText other_avaibility,other_livelihood,other_support,comment;


                other_avaibility = root.findViewById(R.id.other_avaibility);
                String other_avaibility_str=other_avaibility.getText().toString();

                other_livelihood = root.findViewById(R.id.other_livelihood);
                String other_livelihood_str=other_livelihood.getText().toString();

                other_support = root.findViewById(R.id.other_support);
                String other_support_str=other_support.getText().toString();

                comment = root.findViewById(R.id.comment);
                String comment_str=comment.getText().toString();



                if(other_avaibility_str.isEmpty())
                {
                    other_avaibility.setError("This can't be empty");
                    other_avaibility.requestFocus();
                }

                if(other_livelihood_str.isEmpty())
                {
                    other_livelihood.setError("This can't be empty");
                    other_livelihood.requestFocus();
                }

                if(other_support_str.isEmpty())
                {
                    other_support.setError("This can't be empty");
                    other_support.requestFocus();
                }

                Switch where;

                String where_for_job, support_lockdown, skill_upgrade,
                        availability_for_training, present_livelihood,migrate_support,migrate_plan;

                where = root.findViewById(R.id.where_to_go_switch);

                migrate_plan=plan_spinner.getSelectedItem().toString();
                migrate_support=support_spinner.getSelectedItem().toString();
                support_lockdown = support_after.getSelectedItem().toString();
                skill_upgrade = skill_spinner.getSelectedItem().toString();
                availability_for_training = training_spinner.getSelectedItem().toString();
                present_livelihood = live_spinner.getSelectedItem().toString();
                if (where.isChecked()) {
                    where_for_job = "Yes";
                } else {
                    where_for_job = "No";
                }

                Log.d(TAG, "city " + where);
                if(other_avaibility_str=="null"||other_livelihood_str=="null"||other_support_str=="null"||comment_str=="null"){
                    Toast.makeText(getActivity().getApplicationContext(),"Data not saved",Toast.LENGTH_SHORT);
                }else {

                    planDB.addData(where_for_job, support_lockdown,skill_upgrade, availability_for_training, present_livelihood,migrate_plan,migrate_support,other_avaibility_str,other_livelihood_str,other_support_str,comment_str);
                    save.setClickable(false);
                   }
                where.setChecked(false);


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
                    int maritialstatusIdx = personal.getColumnIndex("maritialstatus");
                    int addskillIdx = personal.getColumnIndex("addskill");


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
                    String maritialstatus = personal.getString(maritialstatusIdx);
                    String addskill = personal.getString(addskillIdx);

                    migrant.put("AA.Name", name);
                    migrant.put("AB.Age", age);
                    migrant.put("AC.Gender", gender);
                    migrant.put("AD.Caste", caste);
                    migrant.put("AK.Education", education);
                    migrant.put("AM.PWD", pwd);
                    migrant.put("AF.Pin", pin);
                    migrant.put("AE.Mobile", mob);
                    migrant.put("AG.City", city);
                    migrant.put("AL.Govt_id", govt_id);
                    migrant.put("AJ.Dependants", dependants);
                    migrant.put("AI.Maritial_Status",maritialstatus);
                    migrant.put("AN.Add_Skill",addskill);

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
                    int kindIdx = migration.getColumnIndex("kindofwork");
                    int tychalIdx = migration.getColumnIndex("typechallenge");
                    int reasIdx = migration.getColumnIndex("reason");
                    int amountIdx = migration.getColumnIndex("amount");
                    int houseIdx = migration.getColumnIndex("amounthouse");
                    int otherIdx = migration.getColumnIndex("amountother");
                    int foodIdx = migration.getColumnIndex("amountfood");
                    int transIdx = migration.getColumnIndex("amounttransport");
                    int healthIdx = migration.getColumnIndex("amounthealth");
                    int educaIdx = migration.getColumnIndex("amountedu");
                    int loanIdx = migration.getColumnIndex("amountloan");






                    //int id = personal.getInt(idIdx);
                    String nature = migration.getString(natureIdx);
                    String locn = migration.getString(locIdx);
                    String period = migration.getString(periodIdx);
                    String wage = migration.getString(wageIdx);
                    String employer = migration.getString(employerIdx);
                    double eno = migration.getDouble(enoIdx);
                    String oben = migration.getString(obenIdx);
                    String chal = migration.getString(chalIdx);
                    String kind = migration.getString(kindIdx);
                    String tychal = migration.getString(tychalIdx);
                    String reason = migration.getString(reasIdx);
                    double amount = migration.getDouble(amountIdx);
                    double house = migration.getDouble(houseIdx);
                    double other = migration.getDouble(otherIdx);
                    double food = migration.getDouble(foodIdx);
                    double trans = migration.getDouble(transIdx);
                    double heal = migration.getDouble(healthIdx);
                    double ed = migration.getDouble(educaIdx);
                    double loan = migration.getDouble(loanIdx);




                    migrant.put("BE.Nature", nature);
                    migrant.put("BF.Location", locn);
                    migrant.put("BG.Period", period);
                    migrant.put("BI.Wage", wage);
                    migrant.put("BA.Employer", employer);
                    migrant.put("BB.Employee Number", eno);
                    migrant.put("BL.Other Benefits", oben);
                    migrant.put("BJ.Challenges", chal);
                    migrant.put("BC.Kind Of Work", kind);
                    migrant.put("BK.Type of Challenges", tychal);
                    migrant.put("BD.Reason", reason);
                    migrant.put("BM.Amount", amount);
                    migrant.put("BN.House Rent", house);
                    migrant.put("BO.Other Need", other);
                    migrant.put("BP.Food", food);
                    migrant.put("BQ.Transport", trans);
                    migrant.put("BR.Health", heal);
                    migrant.put("BS.Education Amount", ed);
                    migrant.put("BT.Loan", loan);



                }

                if (awareness.moveToFirst()) {

                    int gvtbenIdx = awareness.getColumnIndex("govt_ben");
                    int cvdIdx = awareness.getColumnIndex("covid_know");
                    int lock_knowIdx = awareness.getColumnIndex("lock_know");
                    int sprtndIdx = awareness.getColumnIndex("support_needed");
                    int cvdslfIdx = awareness.getColumnIndex("covid_self");
                    int schemIdx = awareness.getColumnIndex("schema");
                    int othproIdx = awareness.getColumnIndex("otherproblem");
                    int suggIdx = awareness.getColumnIndex("suggestion");
                    int reIdx = awareness.getColumnIndex("othersupportreceive");



                    migrant.put("CG.Govt Benefits", awareness.getString(gvtbenIdx));
                    migrant.put("CB.Covid Knowledge", awareness.getString(cvdIdx));
                    migrant.put("CE.Lockdown Knowledge", awareness.getString(lock_knowIdx));
                    migrant.put("CF.Support Needed", awareness.getString(sprtndIdx));
                    migrant.put("CK.Covid Self", awareness.getString(cvdslfIdx));
                    migrant.put("CA.Benifits for Migrant worker", awareness.getString(schemIdx));
                    migrant.put("CC.Any Other Problem", awareness.getString(othproIdx));
                    migrant.put("CD.Any Suggestion", awareness.getString(suggIdx));
                    migrant.put("CI.Any Other Support Recieved", awareness.getString(reIdx));

                }

                if (plan.moveToFirst()) {


                    migrant.put("DA.Where for Job", plan.getString(plan.getColumnIndex("where_for_job")));
                    migrant.put("DB.Support Lockdown", plan.getString(plan.getColumnIndex("support_lockdown")));
                    migrant.put("DC.Skill Upgrade", plan.getString(plan.getColumnIndex("skill_upgrade")));
                    migrant.put("DD.Availability for Training ", plan.getString(plan.getColumnIndex("availability_for_training")));
                    migrant.put("DF.Present Livelihood", plan.getString(plan.getColumnIndex("present_livelihood")));
                    migrant.put("DI.MIgrate plan", plan.getString(plan.getColumnIndex("migrate_plan")));
                    migrant.put("DJ.migrate support", plan.getString(plan.getColumnIndex("migrate_support")));
                    migrant.put("DE.other avaibility", plan.getString(plan.getColumnIndex("other_avaibility")));
                    migrant.put("DG.otherlivelihood", plan.getString(plan.getColumnIndex("other_livelihood")));
                    migrant.put("DK.other_support", plan.getString(plan.getColumnIndex("other_support")));
                    migrant.put("DL.comment", plan.getString(plan.getColumnIndex("comment")));

                }


                db.collection("Migrant")
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
                ((questions)getActivity()).selectTab(0);



            }
        });
        return root;
    }

}
