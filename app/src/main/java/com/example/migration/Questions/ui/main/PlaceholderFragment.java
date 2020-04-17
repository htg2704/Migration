package com.example.migration.Questions.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.migration.R;


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
        View root = inflater.inflate(R.layout.fragment_questions, container, false);
        Spinner spinner = (Spinner) root.findViewById(R.id.age_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.age_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        Spinner govt_spinner = (Spinner) root.findViewById(R.id.govt_id_spinner);
        ArrayAdapter<CharSequence> govt_adapter = ArrayAdapter.createFromResource(getContext(), R.array.govt_id, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        govt_spinner.setAdapter(govt_adapter);
        Spinner edu_spinner = (Spinner) root.findViewById(R.id.education_spinner);
        ArrayAdapter<CharSequence> edu_adapter = ArrayAdapter.createFromResource(getContext(), R.array.edu_lvl, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        edu_spinner.setAdapter(edu_adapter);
        Spinner dep_spinner = (Spinner) root.findViewById(R.id.no_of_dependent_spinner);
        ArrayAdapter<CharSequence> dep_adapter = ArrayAdapter.createFromResource(getContext(), R.array.no_of_dep, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dep_spinner.setAdapter(dep_adapter);
        Spinner city_spinner = (Spinner) root.findViewById(R.id.city_spinner);
        ArrayAdapter<CharSequence> city_adapter = ArrayAdapter.createFromResource(getContext(), R.array.india_cities, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        city_spinner.setAdapter(city_adapter);

        return root;
    }
}