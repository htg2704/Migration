package com.example.migration.Questions.ui.main;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

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

        final View root = inflater.inflate(R.layout.fragment_questions, container, false);
        final Spinner spinner = (Spinner) root.findViewById(R.id.age_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.age_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        final Spinner govt_spinner = (Spinner) root.findViewById(R.id.govt_id_spinner);
        ArrayAdapter<CharSequence> govt_adapter = ArrayAdapter.createFromResource(getContext(), R.array.govt_id, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        govt_spinner.setAdapter(govt_adapter);
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
        Button save = root.findViewById(R.id.save_personal);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText name,pin,mobile_no;
                RadioGroup casteR,genderR;
                String name_str,age,gender,caste,dependents,education,id,city;
                Double mobile,pin_no;
                name = root.findViewById(R.id.name);
                pin = root.findViewById(R.id.pin);
                mobile_no = root.findViewById(R.id.mobile_no);
                casteR = root.findViewById(R.id.caste);
                genderR = root.findViewById(R.id.gender);

                RadioButton gen = root.findViewById(genderR.getCheckedRadioButtonId());
                gender = gen.getText().toString();
                RadioButton cas = root.findViewById(casteR.getCheckedRadioButtonId());
                caste = gen.getText().toString();

                name_str = name.getText().toString();
                pin_no = Double.parseDouble(pin.getText().toString());
                mobile = Double.parseDouble(mobile_no.getText().toString());
                age = spinner.getSelectedItem().toString();
                dependents = dep_spinner.getSelectedItem().toString();
                education = edu_spinner.getSelectedItem().toString();
                id = govt_spinner.getSelectedItem().toString();
                city = city_spinner.getSelectedItem().toString();
                Log.d(TAG, "city " + gender);

            }
        });
        return root;
    }
}