package com.example.migration.Questions.ui.main;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.migration.Database.MyDB;
import com.example.migration.Questions.questions;
import com.example.migration.R;

import org.w3c.dom.Text;

import static android.content.ContentValues.TAG;


/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;

    public static PlaceholderFragment newInstance(int index) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

 /*   @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);
    }*/

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        final MyDB myDB = new MyDB(getActivity().getApplicationContext());


        final View root = inflater.inflate(R.layout.fragment_questions, container, false);

        final CheckBox a1,a2,a3,a4,a5,a6,a7;
        a1 = root.findViewById(R.id.a1);
        a2 = root.findViewById(R.id.a2);
        a3 = root.findViewById(R.id.a3);
        a4 = root.findViewById(R.id.a4);
        a5 = root.findViewById(R.id.a5);
        a6 = root.findViewById(R.id.a6);
        a7 = root.findViewById(R.id.a7);

        if(a7.isChecked()){
            a1.setChecked(false);
            a2.setChecked(false);
            a3.setChecked(false);
            a4.setChecked(false);
            a5.setChecked(false);
            a6.setChecked(false);
        }

        final Switch pwd_switch = root.findViewById(R.id.pwd_switch);

        final Spinner spinner = (Spinner) root.findViewById(R.id.age_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.age_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        final Spinner edu_spinner = (Spinner) root.findViewById(R.id.education_spinner);
        ArrayAdapter<CharSequence> edu_adapter = ArrayAdapter.createFromResource(getContext(), R.array.edu_lvl, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        edu_spinner.setAdapter(edu_adapter);
        final Spinner dep_spinner = (Spinner) root.findViewById(R.id.no_of_dependent_spinner);
        ArrayAdapter<CharSequence> dep_adapter = ArrayAdapter.createFromResource(getContext(), R.array.no_of_dep, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dep_spinner.setAdapter(dep_adapter);
        final Spinner city_spinner = (Spinner) root.findViewById(R.id.city_spinner);
        ArrayAdapter<CharSequence> city_adapter = ArrayAdapter.createFromResource(getContext(), R.array.india_cities, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        city_spinner.setAdapter(city_adapter);
        final Spinner maritial_spinner = (Spinner) root.findViewById(R.id.maritial_spinner);
        ArrayAdapter<CharSequence> maritial_adapter = ArrayAdapter.createFromResource(getContext(), R.array.maritial_status, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        maritial_spinner.setAdapter(maritial_adapter);
        final Button save = root.findViewById(R.id.save_personal);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText name,pin,mobile_no,skill;
                RadioGroup casteR,genderR;
                String name_str,age,gender,caste,dependents,education,id,city,pwd,maritial;
                Double mobile,pin_no;
                String s1,s2,s3,s4,s5,s6,s7;

                if(a1.isChecked()){
                    s1 = a1.getText().toString() + ", ";
                }
                else{
                    s1 = "";
                }
                if(a2.isChecked()){
                    s2 = a2.getText().toString() + ", ";
                }
                else{
                    s2 = "";
                }
                if(a3.isChecked()){
                    s3 = a3.getText().toString() + ", ";
                }
                else{
                    s3 = "";
                }
                if(a4.isChecked()){
                    s4 = a4.getText().toString() + ", ";
                }
                else{
                    s4 = "";
                }
                if(a5.isChecked()){
                    s5 = a5.getText().toString() + ", ";
                }
                else{
                    s5 = "";
                }
                if(a6.isChecked()){
                    s6 = a6.getText().toString() + ", ";
                }
                else{
                    s6 = "";
                }
                if(a7.isChecked()){
                    s7 = a7.getText().toString() + ", ";
                }
                else{
                    s7 = "";
                }
                id = s1 + s2 + s3 + s4 +s5 +s6 +s7;

                skill = root.findViewById(R.id.skill);
                String skill_str=skill.getText().toString();


                name = root.findViewById(R.id.name);
                pin = root.findViewById(R.id.pin);
                mobile_no = root.findViewById(R.id.mobile_no);
                casteR = root.findViewById(R.id.caste);
                genderR = root.findViewById(R.id.gender);
                if(genderR.getCheckedRadioButtonId()==-1){
                    gender = "null";
                }
                else{

                    RadioButton gen = root.findViewById(genderR.getCheckedRadioButtonId());
                    gender = gen.getText().toString();
                }
                if(casteR.getCheckedRadioButtonId()==-1){
                    caste = "null";
                }
                else
                { RadioButton cas = root.findViewById(casteR.getCheckedRadioButtonId());
                    caste = cas.getText().toString();

                }
                if(pwd_switch.isChecked()){
                    pwd = "Yes";
                }
                else{
                    pwd = "No";
                }
                name_str = name.getText().toString();
                if(TextUtils.isEmpty(name_str)){
                    name.setError("This can't be empty");
                    name_str = "null";
                    name.requestFocus();
                }

                if(TextUtils.isEmpty(gender)){
                    name_str = "null";
                }


                if(skill_str.isEmpty())
                {
                    skill.setError("This can't be empty");
                    skill.requestFocus();
                }


                if(TextUtils.isEmpty(pin.getText().toString())){
                    pin.setError("This can't be empty");
                    pin_no = 0.0;
                    pin.requestFocus();
                }else {
                    pin_no = Double.parseDouble(pin.getText().toString());
                }
                if(TextUtils.isEmpty(mobile_no.getText().toString())){
                    mobile_no.setError("This can't be empty");
                    mobile = 0.0;
                    mobile_no.requestFocus();
                }else {
                    mobile = Double.parseDouble(mobile_no.getText().toString());
                }

                age = spinner.getSelectedItem().toString();
                dependents = dep_spinner.getSelectedItem().toString();
                education = edu_spinner.getSelectedItem().toString();
                city = city_spinner.getSelectedItem().toString();
                maritial = maritial_spinner.getSelectedItem().toString();
                Log.d(TAG, "city " + gender);
                if(name_str=="null"||pin_no ==0.0||mobile==0.0||gender=="null"||caste=="null"||skill_str=="null"){
                    Toast.makeText(getActivity().getApplicationContext(),"Data not saved",Toast.LENGTH_SHORT);
                }else {
                    myDB.addData(name_str, age, gender, caste, pwd, education, pin_no, mobile, city, id, dependents, maritial,skill_str);
                    save.setClickable(false);
                    ((questions)getActivity()).selectTab(1);
                    Toast.makeText(getActivity().getApplicationContext(),"Demographic data added successfully",Toast.LENGTH_SHORT).show();
                    ((questions)getActivity()).selectTab(1);
                }
                name.setText("");
                pin.setText("");
                mobile_no.setText("");
                skill.setText("");
                pwd_switch.setChecked(false);
                a1.setChecked(false);
                a2.setChecked(false);
                a3.setChecked(false);
                a4.setChecked(false);
                a5.setChecked(false);
                a6.setChecked(false);
                a7.setChecked(false);



            }
        });
        return root;
    }
}