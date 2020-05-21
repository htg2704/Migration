package com.kutumb.migration;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

public class meal_provider extends AppCompatActivity {
    ImageButton btn;
    CardView del1,del2,del3,del4,del5,del6,del7,del8,del9,del10,bih1,che1,che2,che3,che4,odisha,jhar1,tel1,mum1,up1,mum2,mum3,mum4,kar1,kar2,kar3,vij1,mum5,mum6,mum7,mum8;
    TextView detail,no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_provider);


        final Spinner state_spinner  = (Spinner)findViewById(R.id.state);
        ArrayAdapter<CharSequence> state_adapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.state_array, android.R.layout.simple_spinner_item);
        state_adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        state_spinner.setAdapter(state_adapter);

        detail=(TextView)findViewById(R.id.detail);
        detail.setVisibility(View.GONE);
        no=(TextView)findViewById(R.id.no);
        no.setVisibility(View.GONE);
        del1=(CardView)findViewById(R.id.del1);
        del1.setVisibility(View.GONE);
        del2=(CardView)findViewById(R.id.del2);
        del2.setVisibility(View.GONE);
        del3=(CardView)findViewById(R.id.del3);
        del3.setVisibility(View.GONE);
        del4=(CardView)findViewById(R.id.del4);
        del4.setVisibility(View.GONE);
        del5=(CardView)findViewById(R.id.del5);
        del5.setVisibility(View.GONE);
        del6=(CardView)findViewById(R.id.del6);
        del6.setVisibility(View.GONE);
        del7=(CardView)findViewById(R.id.del7);
        del7.setVisibility(View.GONE);
        del8=(CardView)findViewById(R.id.del8);
        del8.setVisibility(View.GONE);
        del9=(CardView)findViewById(R.id.del9);
        del9.setVisibility(View.GONE);
        del10=(CardView)findViewById(R.id.del10);
        del10.setVisibility(View.GONE);
        bih1=(CardView)findViewById(R.id.bih1);
        bih1.setVisibility(View.GONE);
        che1=(CardView)findViewById(R.id.che1);
        che1.setVisibility(View.GONE);
        che2=(CardView)findViewById(R.id.che2);
        che2.setVisibility(View.GONE);
        che3=(CardView)findViewById(R.id.che3);
        che3.setVisibility(View.GONE);
        che4=(CardView)findViewById(R.id.che4);
        che4.setVisibility(View.GONE);
        odisha=(CardView)findViewById(R.id.odis);
        odisha.setVisibility(View.GONE);
        jhar1=(CardView)findViewById(R.id.jhar1);
        jhar1.setVisibility(View.GONE);
        tel1=(CardView)findViewById(R.id.tel1);
        tel1.setVisibility(View.GONE);
        mum1=(CardView)findViewById(R.id.mum1);
        mum1.setVisibility(View.GONE);
        mum2=(CardView)findViewById(R.id.mum2);
        mum2.setVisibility(View.GONE);
        mum3=(CardView)findViewById(R.id.mum3);
        mum3.setVisibility(View.GONE);
        mum4=(CardView)findViewById(R.id.mum4);
        mum4.setVisibility(View.GONE);
        mum5=(CardView)findViewById(R.id.mum5);
        mum5.setVisibility(View.GONE);
        mum6=(CardView)findViewById(R.id.mum6);
        mum6.setVisibility(View.GONE);
        mum7=(CardView)findViewById(R.id.mum7);
        mum7.setVisibility(View.GONE);
        mum8=(CardView)findViewById(R.id.mum8);
        mum8.setVisibility(View.GONE);
        up1=(CardView)findViewById(R.id.up1);
        up1.setVisibility(View.GONE);
        kar1=(CardView)findViewById(R.id.kar1);
        kar1.setVisibility(View.GONE);
        kar2=(CardView)findViewById(R.id.kar2);
        kar2.setVisibility(View.GONE);
        kar3=(CardView)findViewById(R.id.kar3);
        kar3.setVisibility(View.GONE);
        vij1=(CardView)findViewById(R.id.vij1);
        vij1.setVisibility(View.GONE);
        
        state_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onItemSelected(AdapterView<?> arg0, View view,
                                       int position, long row_id) {

                switch(position){
                    case 1:
                        detail.setVisibility(View.VISIBLE);
                        bih1.setVisibility(View.GONE);
                        del1.setVisibility(View.GONE);
                        del2.setVisibility(View.GONE);
                        del3.setVisibility(View.GONE);
                        del4.setVisibility(View.GONE);
                        del5.setVisibility(View.GONE);
                        del6.setVisibility(View.GONE);
                        del7.setVisibility(View.GONE);
                        che1.setVisibility(View.GONE);
                        che2.setVisibility(View.GONE);
                        che3.setVisibility(View.GONE);
                        che4.setVisibility(View.GONE);
                        del8.setVisibility(View.GONE);del9.setVisibility(View.GONE);
del10.setVisibility(View.GONE);
        odisha.setVisibility(View.GONE);
        
        jhar1.setVisibility(View.GONE);
tel1.setVisibility(View.GONE);
        mum1.setVisibility(View.GONE);
        up1.setVisibility(View.GONE);
        mum2.setVisibility(View.GONE);
    mum3.setVisibility(View.GONE);
   kar1.setVisibility(View.GONE);
   kar2.setVisibility(View.GONE);
   kar2.setVisibility(View.GONE);kar3.setVisibility(View.GONE);
   kar2.setVisibility(View.GONE);kar3.setVisibility(View.GONE);mum4.setVisibility(View.GONE);vij1.setVisibility(View.VISIBLE); mum5.setVisibility(View.GONE);mum6.setVisibility(View.GONE);mum7.setVisibility(View.GONE);mum8.setVisibility(View.GONE);no.setVisibility(View.GONE);break;
                        case 2:
                        detail.setVisibility(View.VISIBLE);
                        bih1.setVisibility(View.GONE);
                        del1.setVisibility(View.GONE);
                        del2.setVisibility(View.GONE);
                        del3.setVisibility(View.GONE);
                        del4.setVisibility(View.GONE);
                        del5.setVisibility(View.GONE);
                        del6.setVisibility(View.GONE);
                        del7.setVisibility(View.GONE);
                        che1.setVisibility(View.GONE);
                        che2.setVisibility(View.GONE);
                        che3.setVisibility(View.GONE);
                        che4.setVisibility(View.GONE);
                        del8.setVisibility(View.GONE);del9.setVisibility(View.GONE);
del10.setVisibility(View.GONE);
        odisha.setVisibility(View.GONE);
        
        jhar1.setVisibility(View.GONE);
tel1.setVisibility(View.GONE);
        mum1.setVisibility(View.GONE);
        up1.setVisibility(View.GONE);
        mum2.setVisibility(View.GONE);
    mum3.setVisibility(View.GONE);
    
  
   kar1.setVisibility(View.GONE);
   kar2.setVisibility(View.GONE);kar3.setVisibility(View.GONE);mum4.setVisibility(View.GONE);vij1.setVisibility(View.GONE); mum5.setVisibility(View.GONE);mum6.setVisibility(View.GONE);mum7.setVisibility(View.GONE);mum8.setVisibility(View.GONE);no.setVisibility(View.VISIBLE);break;
                        case 3:
                        detail.setVisibility(View.VISIBLE);
                        bih1.setVisibility(View.GONE);
                        del1.setVisibility(View.GONE);
                        del2.setVisibility(View.GONE);
                        del3.setVisibility(View.GONE);
                        del4.setVisibility(View.GONE);
                        del5.setVisibility(View.GONE);
                        del6.setVisibility(View.GONE);
                        del7.setVisibility(View.GONE);
                        che1.setVisibility(View.GONE);
                        che2.setVisibility(View.GONE);
                        che3.setVisibility(View.GONE);
                        che4.setVisibility(View.GONE);
                        del8.setVisibility(View.GONE);del9.setVisibility(View.GONE);
del10.setVisibility(View.GONE);
        odisha.setVisibility(View.GONE);
        
        jhar1.setVisibility(View.GONE);
tel1.setVisibility(View.GONE);
        mum1.setVisibility(View.GONE);
        up1.setVisibility(View.GONE);
        mum2.setVisibility(View.GONE);
    mum3.setVisibility(View.GONE);
    
  
   kar1.setVisibility(View.GONE);
   kar2.setVisibility(View.GONE);kar3.setVisibility(View.GONE);mum4.setVisibility(View.GONE);vij1.setVisibility(View.GONE); mum5.setVisibility(View.GONE);mum6.setVisibility(View.GONE);mum7.setVisibility(View.GONE);mum8.setVisibility(View.GONE);no.setVisibility(View.VISIBLE);break;
                        case 4:
                        detail.setVisibility(View.VISIBLE);
                        bih1.setVisibility(View.VISIBLE);
                        del1.setVisibility(View.GONE);
                        del2.setVisibility(View.GONE);
                        del3.setVisibility(View.GONE);
                        del4.setVisibility(View.GONE);
                        del5.setVisibility(View.GONE);
                        del6.setVisibility(View.GONE);
                        del7.setVisibility(View.GONE);
                        che1.setVisibility(View.GONE);
                        che2.setVisibility(View.GONE);
                        che3.setVisibility(View.GONE);
                        che4.setVisibility(View.GONE);
                        del8.setVisibility(View.GONE);del9.setVisibility(View.GONE);
del10.setVisibility(View.VISIBLE);
        odisha.setVisibility(View.GONE);
        
        jhar1.setVisibility(View.GONE);
tel1.setVisibility(View.GONE);
        mum1.setVisibility(View.GONE);
        up1.setVisibility(View.GONE);
        mum2.setVisibility(View.GONE);
    mum3.setVisibility(View.GONE);
    
  
   kar1.setVisibility(View.GONE);
   kar2.setVisibility(View.GONE);kar3.setVisibility(View.GONE);mum4.setVisibility(View.GONE);vij1.setVisibility(View.GONE); mum5.setVisibility(View.GONE);mum6.setVisibility(View.GONE);mum7.setVisibility(View.GONE);mum8.setVisibility(View.GONE);no.setVisibility(View.GONE);break;
                        case 5:
                        detail.setVisibility(View.VISIBLE);
                        bih1.setVisibility(View.GONE);
                        del1.setVisibility(View.GONE);
                        del2.setVisibility(View.GONE);
                        del3.setVisibility(View.GONE);
                        del4.setVisibility(View.GONE);
                        del5.setVisibility(View.GONE);
                        del6.setVisibility(View.GONE);
                        del7.setVisibility(View.GONE);
                        che1.setVisibility(View.GONE);
                        che2.setVisibility(View.GONE);
                        che3.setVisibility(View.GONE);
                        che4.setVisibility(View.GONE);
                        del8.setVisibility(View.GONE);del9.setVisibility(View.GONE);
del10.setVisibility(View.GONE);
        odisha.setVisibility(View.GONE);
        
        jhar1.setVisibility(View.GONE);
tel1.setVisibility(View.GONE);
        mum1.setVisibility(View.GONE);
        up1.setVisibility(View.GONE);
        mum2.setVisibility(View.GONE);
    mum3.setVisibility(View.GONE);
    
  
   kar1.setVisibility(View.GONE);
   kar2.setVisibility(View.GONE);kar3.setVisibility(View.GONE);mum4.setVisibility(View.GONE);vij1.setVisibility(View.GONE); mum5.setVisibility(View.GONE);mum6.setVisibility(View.GONE);mum7.setVisibility(View.GONE);mum8.setVisibility(View.GONE);no.setVisibility(View.VISIBLE);break;
                        case 6:
                        detail.setVisibility(View.VISIBLE);
                        del1.setVisibility(View.VISIBLE);
                        del2.setVisibility(View.VISIBLE);
                        del3.setVisibility(View.VISIBLE);
                        del4.setVisibility(View.VISIBLE);
                        del5.setVisibility(View.VISIBLE);
                        del6.setVisibility(View.VISIBLE);
                        del7.setVisibility(View.VISIBLE);
                        del8.setVisibility(View.VISIBLE);
                        bih1.setVisibility(View.GONE);
                            del9.setVisibility(View.VISIBLE);
                            del10.setVisibility(View.VISIBLE);
                        che1.setVisibility(View.GONE);
                        che2.setVisibility(View.GONE);
                        che3.setVisibility(View.GONE);
                        che4.setVisibility(View.GONE);
        odisha.setVisibility(View.GONE);
        
        jhar1.setVisibility(View.GONE);
tel1.setVisibility(View.GONE);
        mum1.setVisibility(View.GONE);
        up1.setVisibility(View.GONE);
        mum2.setVisibility(View.GONE);
    mum3.setVisibility(View.GONE);
    
  
   kar1.setVisibility(View.GONE);
   kar2.setVisibility(View.GONE);kar3.setVisibility(View.GONE);mum4.setVisibility(View.GONE);vij1.setVisibility(View.GONE); mum5.setVisibility(View.GONE);mum6.setVisibility(View.GONE);mum7.setVisibility(View.GONE);mum8.setVisibility(View.GONE);no.setVisibility(View.GONE);break;
                        case 7:
                        detail.setVisibility(View.VISIBLE);
                        bih1.setVisibility(View.GONE);
                        del1.setVisibility(View.GONE);
                        del2.setVisibility(View.GONE);
                        del3.setVisibility(View.GONE);
                        del4.setVisibility(View.GONE);
                        del5.setVisibility(View.GONE);
                        del6.setVisibility(View.GONE);
                        del7.setVisibility(View.GONE);
                        che1.setVisibility(View.GONE);
                        che2.setVisibility(View.GONE);
                        che3.setVisibility(View.GONE);
                        che4.setVisibility(View.GONE);
                        del8.setVisibility(View.GONE);del9.setVisibility(View.GONE);
del10.setVisibility(View.GONE);
        odisha.setVisibility(View.GONE);
        
        jhar1.setVisibility(View.GONE);
tel1.setVisibility(View.GONE);
        mum1.setVisibility(View.GONE);
        up1.setVisibility(View.GONE);
        mum2.setVisibility(View.GONE);
    mum3.setVisibility(View.GONE);
    
  
   kar1.setVisibility(View.GONE);
   kar2.setVisibility(View.GONE);kar3.setVisibility(View.GONE);mum4.setVisibility(View.GONE);vij1.setVisibility(View.GONE); mum5.setVisibility(View.GONE);mum6.setVisibility(View.GONE);mum7.setVisibility(View.GONE);mum8.setVisibility(View.GONE);no.setVisibility(View.VISIBLE);break;
                        case 8:
                        detail.setVisibility(View.VISIBLE);
                        bih1.setVisibility(View.GONE);
                        del1.setVisibility(View.GONE);
                        del2.setVisibility(View.GONE);
                        del3.setVisibility(View.GONE);
                        del4.setVisibility(View.GONE);
                        del5.setVisibility(View.GONE);
                        del6.setVisibility(View.GONE);
                        del7.setVisibility(View.GONE);
                        che1.setVisibility(View.GONE);
                        che2.setVisibility(View.GONE);
                        che3.setVisibility(View.GONE);
                        che4.setVisibility(View.GONE);
                        del8.setVisibility(View.GONE);del9.setVisibility(View.GONE);
del10.setVisibility(View.GONE);
        odisha.setVisibility(View.GONE);
        
        jhar1.setVisibility(View.GONE);
tel1.setVisibility(View.GONE);
        mum1.setVisibility(View.GONE);
        up1.setVisibility(View.GONE);
        mum2.setVisibility(View.GONE);
    mum3.setVisibility(View.GONE);
    
  
   kar1.setVisibility(View.GONE);
   kar2.setVisibility(View.GONE);kar3.setVisibility(View.GONE);mum4.setVisibility(View.GONE);vij1.setVisibility(View.GONE); mum5.setVisibility(View.GONE);mum6.setVisibility(View.GONE);mum7.setVisibility(View.GONE);mum8.setVisibility(View.GONE);no.setVisibility(View.VISIBLE);break;
                        case 9:
                        detail.setVisibility(View.VISIBLE);
                        bih1.setVisibility(View.GONE);
                        del1.setVisibility(View.GONE);
                        del2.setVisibility(View.GONE);
                        del3.setVisibility(View.GONE);
                        del4.setVisibility(View.GONE);
                        del5.setVisibility(View.GONE);
                        del6.setVisibility(View.GONE);
                        del7.setVisibility(View.GONE);
                        che1.setVisibility(View.GONE);
                        che2.setVisibility(View.GONE);
                        che3.setVisibility(View.GONE);
                        che4.setVisibility(View.GONE);
                        del8.setVisibility(View.GONE);del9.setVisibility(View.GONE);
del10.setVisibility(View.GONE);
        odisha.setVisibility(View.GONE);
        
        jhar1.setVisibility(View.GONE);
tel1.setVisibility(View.GONE);
        mum1.setVisibility(View.GONE);
        up1.setVisibility(View.GONE);
        mum2.setVisibility(View.GONE);
    mum3.setVisibility(View.GONE);
    
  
   kar1.setVisibility(View.GONE);
   kar2.setVisibility(View.GONE);kar3.setVisibility(View.GONE);mum4.setVisibility(View.GONE);vij1.setVisibility(View.GONE); mum5.setVisibility(View.GONE);mum6.setVisibility(View.GONE);mum7.setVisibility(View.GONE);mum8.setVisibility(View.GONE);no.setVisibility(View.VISIBLE);break;
                        case 10:
                        detail.setVisibility(View.VISIBLE);
                        bih1.setVisibility(View.GONE);
                        del1.setVisibility(View.GONE);
                        del2.setVisibility(View.GONE);
                        del3.setVisibility(View.GONE);
                        del4.setVisibility(View.GONE);
                        del5.setVisibility(View.GONE);
                        del6.setVisibility(View.GONE);
                        del7.setVisibility(View.GONE);
                        che1.setVisibility(View.GONE);
                        che2.setVisibility(View.GONE);
                        che3.setVisibility(View.GONE);
                        che4.setVisibility(View.GONE);
                        del8.setVisibility(View.GONE);del9.setVisibility(View.GONE);
del10.setVisibility(View.GONE);
        odisha.setVisibility(View.GONE);
        
        jhar1.setVisibility(View.GONE);
tel1.setVisibility(View.GONE);
        mum1.setVisibility(View.GONE);
        up1.setVisibility(View.GONE);
        mum2.setVisibility(View.GONE);
    mum3.setVisibility(View.GONE);
    
  
   kar1.setVisibility(View.GONE);
   kar2.setVisibility(View.GONE);kar3.setVisibility(View.GONE);mum4.setVisibility(View.GONE);vij1.setVisibility(View.GONE); mum5.setVisibility(View.GONE);mum6.setVisibility(View.GONE);mum7.setVisibility(View.GONE);mum8.setVisibility(View.GONE);no.setVisibility(View.VISIBLE);break;
                        case 11:
                        detail.setVisibility(View.VISIBLE);
                        bih1.setVisibility(View.GONE);
                        del1.setVisibility(View.GONE);
                        del2.setVisibility(View.GONE);
                        del3.setVisibility(View.GONE);
                        del4.setVisibility(View.GONE);
                        del5.setVisibility(View.GONE);
                        del6.setVisibility(View.GONE);
                        del7.setVisibility(View.GONE);
                        che1.setVisibility(View.GONE);
                        che2.setVisibility(View.GONE);
                        che3.setVisibility(View.GONE);
                        che4.setVisibility(View.GONE);
                        del8.setVisibility(View.GONE);del9.setVisibility(View.GONE);
del10.setVisibility(View.GONE);
        odisha.setVisibility(View.GONE);
        
        jhar1.setVisibility(View.GONE);
tel1.setVisibility(View.GONE);
        mum1.setVisibility(View.GONE);
        up1.setVisibility(View.GONE);
        mum2.setVisibility(View.GONE);
    mum3.setVisibility(View.GONE);
    
  
   kar1.setVisibility(View.GONE);
   kar2.setVisibility(View.GONE);kar3.setVisibility(View.GONE);mum4.setVisibility(View.GONE);vij1.setVisibility(View.GONE); mum5.setVisibility(View.GONE);mum6.setVisibility(View.GONE);mum7.setVisibility(View.GONE);mum8.setVisibility(View.GONE);no.setVisibility(View.VISIBLE);break;
                        case 12:
                        detail.setVisibility(View.VISIBLE);
                        bih1.setVisibility(View.GONE);
                        del1.setVisibility(View.GONE);
                        del2.setVisibility(View.GONE);
                        del3.setVisibility(View.GONE);
                        del4.setVisibility(View.GONE);
                        del5.setVisibility(View.GONE);
                        del6.setVisibility(View.GONE);
                        del7.setVisibility(View.GONE);
                        che1.setVisibility(View.GONE);
                        che2.setVisibility(View.GONE);
                        che3.setVisibility(View.GONE);
                        che4.setVisibility(View.GONE);
                        del8.setVisibility(View.GONE);del9.setVisibility(View.GONE);
del10.setVisibility(View.GONE);
        odisha.setVisibility(View.GONE);
        
        jhar1.setVisibility(View.VISIBLE);
tel1.setVisibility(View.GONE);
        mum1.setVisibility(View.GONE);
        up1.setVisibility(View.GONE);
        mum2.setVisibility(View.GONE);
    mum3.setVisibility(View.GONE);
    
  
   kar1.setVisibility(View.GONE);
   kar2.setVisibility(View.GONE);kar3.setVisibility(View.GONE);mum4.setVisibility(View.GONE);vij1.setVisibility(View.GONE); mum5.setVisibility(View.GONE);mum6.setVisibility(View.GONE);mum7.setVisibility(View.GONE);mum8.setVisibility(View.GONE);no.setVisibility(View.GONE);break;
                        case 13:
                        detail.setVisibility(View.VISIBLE);
                        bih1.setVisibility(View.GONE);
                        del1.setVisibility(View.GONE);
                        del2.setVisibility(View.GONE);
                        del3.setVisibility(View.GONE);
                        del4.setVisibility(View.GONE);
                        del5.setVisibility(View.GONE);
                        del6.setVisibility(View.GONE);
                        del7.setVisibility(View.GONE);
                        che1.setVisibility(View.GONE);
                        che2.setVisibility(View.GONE);
                        che3.setVisibility(View.GONE);
                        che4.setVisibility(View.GONE);
                        del8.setVisibility(View.VISIBLE);del9.setVisibility(View.VISIBLE);
del10.setVisibility(View.VISIBLE);
        odisha.setVisibility(View.GONE);
        
        jhar1.setVisibility(View.GONE);
tel1.setVisibility(View.GONE);
        mum1.setVisibility(View.GONE);
        up1.setVisibility(View.GONE);
        mum2.setVisibility(View.GONE);
    mum3.setVisibility(View.GONE);
    
  
   kar1.setVisibility(View.VISIBLE);
   kar2.setVisibility(View.VISIBLE);kar3.setVisibility(View.VISIBLE);mum4.setVisibility(View.GONE);vij1.setVisibility(View.GONE); mum5.setVisibility(View.GONE);mum6.setVisibility(View.GONE);mum7.setVisibility(View.GONE);mum8.setVisibility(View.GONE);no.setVisibility(View.GONE);break;
                        case 14:
                        detail.setVisibility(View.VISIBLE);
                        bih1.setVisibility(View.GONE);
                        del1.setVisibility(View.GONE);
                        del2.setVisibility(View.GONE);
                        del3.setVisibility(View.GONE);
                        del4.setVisibility(View.GONE);
                        del5.setVisibility(View.GONE);
                        del6.setVisibility(View.GONE);
                        del7.setVisibility(View.GONE);
                        che1.setVisibility(View.GONE);
                        che2.setVisibility(View.GONE);
                        che3.setVisibility(View.GONE);
                        che4.setVisibility(View.GONE);
                        del8.setVisibility(View.GONE);del9.setVisibility(View.GONE);
del10.setVisibility(View.VISIBLE);
        odisha.setVisibility(View.GONE);
        
        jhar1.setVisibility(View.GONE);
tel1.setVisibility(View.GONE);
        mum1.setVisibility(View.GONE);
        up1.setVisibility(View.GONE);
        mum2.setVisibility(View.GONE);
    mum3.setVisibility(View.GONE);
    
  
   kar1.setVisibility(View.GONE);
   kar2.setVisibility(View.GONE);kar3.setVisibility(View.GONE);mum4.setVisibility(View.GONE);vij1.setVisibility(View.GONE); mum5.setVisibility(View.GONE);mum6.setVisibility(View.GONE);mum7.setVisibility(View.GONE);mum8.setVisibility(View.GONE);no.setVisibility(View.GONE);break;
                        case 15:
                        detail.setVisibility(View.VISIBLE);
                        bih1.setVisibility(View.GONE);
                        del1.setVisibility(View.GONE);
                        del2.setVisibility(View.GONE);
                        del3.setVisibility(View.GONE);
                        del4.setVisibility(View.GONE);
                        del5.setVisibility(View.GONE);
                        del6.setVisibility(View.GONE);
                        del7.setVisibility(View.GONE);
                        che1.setVisibility(View.GONE);
                        che2.setVisibility(View.GONE);
                        che3.setVisibility(View.GONE);
                        che4.setVisibility(View.GONE);
                        del8.setVisibility(View.GONE);del9.setVisibility(View.GONE);
del10.setVisibility(View.GONE);
        odisha.setVisibility(View.GONE);
        
        jhar1.setVisibility(View.GONE);
tel1.setVisibility(View.GONE);
        mum1.setVisibility(View.GONE);
        up1.setVisibility(View.GONE);
        mum2.setVisibility(View.GONE);
    mum3.setVisibility(View.GONE);
    
  
   kar1.setVisibility(View.GONE);
   kar2.setVisibility(View.GONE);kar3.setVisibility(View.GONE);mum4.setVisibility(View.GONE);vij1.setVisibility(View.GONE); mum5.setVisibility(View.GONE);mum6.setVisibility(View.GONE);mum7.setVisibility(View.GONE);mum8.setVisibility(View.GONE);no.setVisibility(View.VISIBLE);break;
                        case 16:
                        detail.setVisibility(View.VISIBLE);
                        bih1.setVisibility(View.GONE);
                        del1.setVisibility(View.GONE);
                        del2.setVisibility(View.GONE);
                        del3.setVisibility(View.GONE);
                        del4.setVisibility(View.GONE);
                        del5.setVisibility(View.GONE);
                        del6.setVisibility(View.GONE);
                        del7.setVisibility(View.GONE);
                        che1.setVisibility(View.GONE);
                        che2.setVisibility(View.GONE);
                        che3.setVisibility(View.GONE);
                        che4.setVisibility(View.GONE);
                        del8.setVisibility(View.VISIBLE);del9.setVisibility(View.VISIBLE);
del10.setVisibility(View.VISIBLE);
        odisha.setVisibility(View.GONE);
        
        jhar1.setVisibility(View.GONE);
tel1.setVisibility(View.GONE);
        mum1.setVisibility(View.VISIBLE);
        up1.setVisibility(View.GONE);
        mum2.setVisibility(View.VISIBLE);
    mum3.setVisibility(View.VISIBLE);
   kar1.setVisibility(View.GONE);
   kar2.setVisibility(View.GONE);kar3.setVisibility(View.GONE);mum4.setVisibility(View.VISIBLE);vij1.setVisibility(View.GONE); mum5.setVisibility(View.VISIBLE);mum6.setVisibility(View.VISIBLE);mum7.setVisibility(View.VISIBLE);mum8.setVisibility(View.VISIBLE);no.setVisibility(View.GONE);break;
                        case 17:
                        detail.setVisibility(View.VISIBLE);
                        bih1.setVisibility(View.GONE);
                        del1.setVisibility(View.GONE);
                        del2.setVisibility(View.GONE);
                        del3.setVisibility(View.GONE);
                        del4.setVisibility(View.GONE);
                        del5.setVisibility(View.GONE);
                        del6.setVisibility(View.GONE);
                        del7.setVisibility(View.GONE);
                        che1.setVisibility(View.GONE);
                        che2.setVisibility(View.GONE);
                        che3.setVisibility(View.GONE);
                        che4.setVisibility(View.GONE);
                        del8.setVisibility(View.GONE);del9.setVisibility(View.GONE);
del10.setVisibility(View.GONE);
        odisha.setVisibility(View.GONE);
        
        jhar1.setVisibility(View.GONE);
tel1.setVisibility(View.GONE);
        mum1.setVisibility(View.GONE);
        up1.setVisibility(View.GONE);
        mum2.setVisibility(View.GONE);
    mum3.setVisibility(View.GONE);
    
  
   kar1.setVisibility(View.GONE);
   kar2.setVisibility(View.GONE);kar3.setVisibility(View.GONE);mum4.setVisibility(View.GONE);vij1.setVisibility(View.GONE); mum5.setVisibility(View.GONE);mum6.setVisibility(View.GONE);mum7.setVisibility(View.GONE);mum8.setVisibility(View.GONE);no.setVisibility(View.VISIBLE);break;
                        case 18:
                        detail.setVisibility(View.VISIBLE);
                        bih1.setVisibility(View.GONE);
                        del1.setVisibility(View.GONE);
                        del2.setVisibility(View.GONE);
                        del3.setVisibility(View.GONE);
                        del4.setVisibility(View.GONE);
                        del5.setVisibility(View.GONE);
                        del6.setVisibility(View.GONE);
                        del7.setVisibility(View.GONE);
                        che1.setVisibility(View.GONE);
                        che2.setVisibility(View.GONE);
                        che3.setVisibility(View.GONE);
                        che4.setVisibility(View.GONE);
                        del8.setVisibility(View.GONE);del9.setVisibility(View.GONE);
del10.setVisibility(View.GONE);
        odisha.setVisibility(View.GONE);
        
        jhar1.setVisibility(View.GONE);
tel1.setVisibility(View.GONE);
        mum1.setVisibility(View.GONE);
        up1.setVisibility(View.GONE);
        mum2.setVisibility(View.GONE);
    mum3.setVisibility(View.GONE);
    
  
   kar1.setVisibility(View.GONE);
   kar2.setVisibility(View.GONE);kar3.setVisibility(View.GONE);mum4.setVisibility(View.GONE);vij1.setVisibility(View.GONE); mum5.setVisibility(View.GONE);mum6.setVisibility(View.GONE);mum7.setVisibility(View.GONE);mum8.setVisibility(View.GONE);no.setVisibility(View.VISIBLE);break;
                        case 19:
                        detail.setVisibility(View.VISIBLE);
                        bih1.setVisibility(View.GONE);
                        del1.setVisibility(View.GONE);
                        del2.setVisibility(View.GONE);
                        del3.setVisibility(View.GONE);
                        del4.setVisibility(View.GONE);
                        del5.setVisibility(View.GONE);
                        del6.setVisibility(View.GONE);
                        del7.setVisibility(View.GONE);
                        che1.setVisibility(View.GONE);
                        che2.setVisibility(View.GONE);
                        che3.setVisibility(View.GONE);
                        che4.setVisibility(View.GONE);
                        del8.setVisibility(View.GONE);del9.setVisibility(View.GONE);
del10.setVisibility(View.GONE);
        odisha.setVisibility(View.GONE);
        
        jhar1.setVisibility(View.GONE);
tel1.setVisibility(View.GONE);
        mum1.setVisibility(View.GONE);
        up1.setVisibility(View.GONE);
        mum2.setVisibility(View.GONE);
    mum3.setVisibility(View.GONE);
    
  
   kar1.setVisibility(View.GONE);
   kar2.setVisibility(View.GONE);kar3.setVisibility(View.GONE);mum4.setVisibility(View.GONE);vij1.setVisibility(View.GONE); mum5.setVisibility(View.GONE);mum6.setVisibility(View.GONE);mum7.setVisibility(View.GONE);mum8.setVisibility(View.GONE);no.setVisibility(View.VISIBLE);break;
                        case 20:
                        detail.setVisibility(View.VISIBLE);
                        bih1.setVisibility(View.GONE);
                        del1.setVisibility(View.GONE);
                        del2.setVisibility(View.GONE);
                        del3.setVisibility(View.GONE);
                        del4.setVisibility(View.GONE);
                        del5.setVisibility(View.GONE);
                        del6.setVisibility(View.GONE);
                        del7.setVisibility(View.GONE);
                        che1.setVisibility(View.GONE);
                        che2.setVisibility(View.GONE);
                        che3.setVisibility(View.GONE);
                        che4.setVisibility(View.GONE);
                        del8.setVisibility(View.GONE);del9.setVisibility(View.GONE);
del10.setVisibility(View.GONE);
        odisha.setVisibility(View.GONE);
        
        jhar1.setVisibility(View.GONE);
tel1.setVisibility(View.GONE);
        mum1.setVisibility(View.GONE);
        up1.setVisibility(View.GONE);
        mum2.setVisibility(View.GONE);
    mum3.setVisibility(View.GONE);
    
  
   kar1.setVisibility(View.GONE);
   kar2.setVisibility(View.GONE);kar3.setVisibility(View.GONE);mum4.setVisibility(View.GONE);vij1.setVisibility(View.GONE); mum5.setVisibility(View.GONE);mum6.setVisibility(View.GONE);mum7.setVisibility(View.GONE);mum8.setVisibility(View.GONE);no.setVisibility(View.VISIBLE);break;
                        case 21:
                        detail.setVisibility(View.VISIBLE);
                        bih1.setVisibility(View.GONE);
                        del1.setVisibility(View.GONE);
                        del2.setVisibility(View.GONE);
                        del3.setVisibility(View.GONE);
                        del4.setVisibility(View.GONE);
                        del5.setVisibility(View.GONE);
                        del6.setVisibility(View.GONE);
                        del7.setVisibility(View.GONE);
                        che1.setVisibility(View.GONE);
                        che2.setVisibility(View.GONE);
                        che3.setVisibility(View.GONE);
                        che4.setVisibility(View.GONE);
                        del8.setVisibility(View.GONE);del9.setVisibility(View.GONE);
del10.setVisibility(View.GONE);
        odisha.setVisibility(View.VISIBLE);
        
        jhar1.setVisibility(View.GONE);
tel1.setVisibility(View.GONE);
        mum1.setVisibility(View.GONE);
        up1.setVisibility(View.GONE);
        mum2.setVisibility(View.GONE);
    mum3.setVisibility(View.GONE);
    
  
   kar1.setVisibility(View.GONE);
   kar2.setVisibility(View.GONE);kar3.setVisibility(View.GONE);mum4.setVisibility(View.GONE);vij1.setVisibility(View.GONE); mum5.setVisibility(View.GONE);mum6.setVisibility(View.GONE);mum7.setVisibility(View.GONE);mum8.setVisibility(View.GONE);no.setVisibility(View.GONE);break;
                        case 22:
                        detail.setVisibility(View.VISIBLE);
                        bih1.setVisibility(View.GONE);
                        del1.setVisibility(View.GONE);
                        del2.setVisibility(View.GONE);
                        del3.setVisibility(View.GONE);
                        del4.setVisibility(View.GONE);
                        del5.setVisibility(View.GONE);
                        del6.setVisibility(View.GONE);
                        del7.setVisibility(View.GONE);
                        che1.setVisibility(View.GONE);
                        che2.setVisibility(View.GONE);
                        che3.setVisibility(View.GONE);
                        che4.setVisibility(View.GONE);
                        del8.setVisibility(View.GONE);del9.setVisibility(View.GONE);
del10.setVisibility(View.GONE);
        odisha.setVisibility(View.GONE);
        
        jhar1.setVisibility(View.GONE);
tel1.setVisibility(View.GONE);
        mum1.setVisibility(View.GONE);
        up1.setVisibility(View.GONE);
        mum2.setVisibility(View.GONE);
    mum3.setVisibility(View.GONE);
    
  
   kar1.setVisibility(View.GONE);
   kar2.setVisibility(View.GONE);kar3.setVisibility(View.GONE);mum4.setVisibility(View.GONE);vij1.setVisibility(View.GONE); mum5.setVisibility(View.GONE);mum6.setVisibility(View.GONE);mum7.setVisibility(View.GONE);mum8.setVisibility(View.GONE);no.setVisibility(View.VISIBLE);break;
                        case 23:
                        detail.setVisibility(View.VISIBLE);
                        bih1.setVisibility(View.GONE);
                        del1.setVisibility(View.GONE);
                        del2.setVisibility(View.GONE);
                        del3.setVisibility(View.GONE);
                        del4.setVisibility(View.GONE);
                        del5.setVisibility(View.GONE);
                        del6.setVisibility(View.GONE);
                        del7.setVisibility(View.GONE);
                        che1.setVisibility(View.GONE);
                        che2.setVisibility(View.GONE);
                        che3.setVisibility(View.GONE);
                        che4.setVisibility(View.GONE);
                        del8.setVisibility(View.GONE);del9.setVisibility(View.GONE);
del10.setVisibility(View.GONE);
        odisha.setVisibility(View.GONE);
        
        jhar1.setVisibility(View.GONE);
tel1.setVisibility(View.GONE);
        mum1.setVisibility(View.GONE);
        up1.setVisibility(View.GONE);
        mum2.setVisibility(View.GONE);
    mum3.setVisibility(View.GONE);
    
  
   kar1.setVisibility(View.GONE);
   kar2.setVisibility(View.GONE);kar3.setVisibility(View.GONE);mum4.setVisibility(View.GONE);vij1.setVisibility(View.GONE); mum5.setVisibility(View.GONE);mum6.setVisibility(View.GONE);mum7.setVisibility(View.GONE);mum8.setVisibility(View.GONE);no.setVisibility(View.VISIBLE);break;
                        case 24:
                        detail.setVisibility(View.VISIBLE);
                        bih1.setVisibility(View.GONE);
                        del1.setVisibility(View.GONE);
                        del2.setVisibility(View.GONE);
                        del3.setVisibility(View.GONE);
                        del4.setVisibility(View.GONE);
                        del5.setVisibility(View.GONE);
                        del6.setVisibility(View.GONE);
                        del7.setVisibility(View.GONE);
                        che1.setVisibility(View.GONE);
                        che2.setVisibility(View.GONE);
                        che3.setVisibility(View.GONE);
                        che4.setVisibility(View.GONE);
                        del8.setVisibility(View.GONE);del9.setVisibility(View.GONE);
del10.setVisibility(View.GONE);
        odisha.setVisibility(View.GONE);
        
        jhar1.setVisibility(View.GONE);
tel1.setVisibility(View.VISIBLE);
        mum1.setVisibility(View.GONE);
        up1.setVisibility(View.GONE);
        mum2.setVisibility(View.GONE);
    mum3.setVisibility(View.GONE);
    
  
   kar1.setVisibility(View.GONE);
   kar2.setVisibility(View.GONE);kar3.setVisibility(View.GONE);mum4.setVisibility(View.GONE);vij1.setVisibility(View.GONE); mum5.setVisibility(View.GONE);mum6.setVisibility(View.GONE);mum7.setVisibility(View.GONE);mum8.setVisibility(View.GONE);no.setVisibility(View.GONE);break;
                        case 25:
                        detail.setVisibility(View.VISIBLE);
                        bih1.setVisibility(View.GONE);
                        del1.setVisibility(View.GONE);
                        del2.setVisibility(View.GONE);
                        del3.setVisibility(View.GONE);
                        del4.setVisibility(View.GONE);
                        del5.setVisibility(View.GONE);
                        del6.setVisibility(View.GONE);
                        del7.setVisibility(View.GONE);
                        che1.setVisibility(View.VISIBLE);
                        che2.setVisibility(View.VISIBLE);
                        che3.setVisibility(View.VISIBLE);
                        che4.setVisibility(View.VISIBLE);
                        del8.setVisibility(View.GONE);del9.setVisibility(View.GONE);
del10.setVisibility(View.VISIBLE);
        odisha.setVisibility(View.GONE);
        
        jhar1.setVisibility(View.GONE);
tel1.setVisibility(View.GONE);
        mum1.setVisibility(View.GONE);
        up1.setVisibility(View.GONE);
        mum2.setVisibility(View.GONE);
    mum3.setVisibility(View.GONE);
    
  
   kar1.setVisibility(View.GONE);
   kar2.setVisibility(View.GONE);kar3.setVisibility(View.GONE);mum4.setVisibility(View.GONE);vij1.setVisibility(View.GONE); mum5.setVisibility(View.GONE);mum6.setVisibility(View.GONE);mum7.setVisibility(View.GONE);mum8.setVisibility(View.GONE);no.setVisibility(View.GONE);break;
                        case 26:
                        detail.setVisibility(View.VISIBLE);
                        bih1.setVisibility(View.GONE);
                        del1.setVisibility(View.GONE);
                        del2.setVisibility(View.GONE);
                        del3.setVisibility(View.GONE);
                        del4.setVisibility(View.GONE);
                        del5.setVisibility(View.GONE);
                        del6.setVisibility(View.GONE);
                        del7.setVisibility(View.GONE);
                        che1.setVisibility(View.GONE);
                        che2.setVisibility(View.GONE);
                        che3.setVisibility(View.GONE);

                        che4.setVisibility(View.GONE);
                        del8.setVisibility(View.VISIBLE);del9.setVisibility(View.VISIBLE);
del10.setVisibility(View.VISIBLE);
        odisha.setVisibility(View.GONE);
        
        jhar1.setVisibility(View.GONE);
tel1.setVisibility(View.VISIBLE);
        mum1.setVisibility(View.GONE);
        up1.setVisibility(View.GONE);
        mum2.setVisibility(View.GONE);
    mum3.setVisibility(View.GONE);
    
  
   kar1.setVisibility(View.GONE);
   kar2.setVisibility(View.GONE);kar3.setVisibility(View.GONE);mum4.setVisibility(View.GONE);vij1.setVisibility(View.GONE); mum5.setVisibility(View.GONE);mum6.setVisibility(View.GONE);mum7.setVisibility(View.GONE);mum8.setVisibility(View.GONE);no.setVisibility(View.GONE);break;
                        case 27:
                        detail.setVisibility(View.VISIBLE);
                        bih1.setVisibility(View.GONE);
                        del1.setVisibility(View.GONE);
                        del2.setVisibility(View.GONE);
                        del3.setVisibility(View.GONE);
                        del4.setVisibility(View.GONE);
                        del5.setVisibility(View.GONE);
                        del6.setVisibility(View.GONE);
                        del7.setVisibility(View.GONE);
                        che1.setVisibility(View.GONE);
                        che2.setVisibility(View.GONE);
                        che3.setVisibility(View.GONE);
                        che4.setVisibility(View.GONE);
                        del8.setVisibility(View.GONE);del9.setVisibility(View.GONE);
del10.setVisibility(View.GONE);
        odisha.setVisibility(View.GONE);
        
        jhar1.setVisibility(View.GONE);
tel1.setVisibility(View.GONE);
        mum1.setVisibility(View.GONE);
        up1.setVisibility(View.GONE);
        mum2.setVisibility(View.GONE);
    mum3.setVisibility(View.GONE);
    
  
   kar1.setVisibility(View.GONE);
   kar2.setVisibility(View.GONE);kar3.setVisibility(View.GONE);mum4.setVisibility(View.GONE);vij1.setVisibility(View.GONE); mum5.setVisibility(View.GONE);mum6.setVisibility(View.GONE);mum7.setVisibility(View.GONE);mum8.setVisibility(View.GONE);no.setVisibility(View.VISIBLE);break;
                        case 28:
                        detail.setVisibility(View.VISIBLE);
                        bih1.setVisibility(View.GONE);
                        del1.setVisibility(View.GONE);
                        del2.setVisibility(View.GONE);
                        del3.setVisibility(View.GONE);
                        del4.setVisibility(View.GONE);
                        del5.setVisibility(View.GONE);
                        del6.setVisibility(View.GONE);
                        del7.setVisibility(View.GONE);
                        che1.setVisibility(View.GONE);
                        che2.setVisibility(View.GONE);
                        che3.setVisibility(View.GONE);
                        che4.setVisibility(View.GONE);
                        del8.setVisibility(View.GONE);del9.setVisibility(View.GONE);
del10.setVisibility(View.VISIBLE);
        odisha.setVisibility(View.GONE);
        
        jhar1.setVisibility(View.GONE);
tel1.setVisibility(View.GONE);
        mum1.setVisibility(View.GONE);
        up1.setVisibility(View.GONE);
        mum2.setVisibility(View.GONE);
    mum3.setVisibility(View.GONE);
    
  
   kar1.setVisibility(View.GONE);
   kar2.setVisibility(View.GONE);kar3.setVisibility(View.GONE);mum4.setVisibility(View.GONE);vij1.setVisibility(View.GONE); mum5.setVisibility(View.GONE);mum6.setVisibility(View.GONE);mum7.setVisibility(View.GONE);mum8.setVisibility(View.GONE);no.setVisibility(View.GONE);break;
                        case 29:
                        detail.setVisibility(View.VISIBLE);
                        bih1.setVisibility(View.GONE);
                        del1.setVisibility(View.GONE);
                        del2.setVisibility(View.GONE);
                        del3.setVisibility(View.GONE);
                        del4.setVisibility(View.GONE);
                        del5.setVisibility(View.GONE);
                        del6.setVisibility(View.GONE);
                        del7.setVisibility(View.GONE);
                        che1.setVisibility(View.GONE);
                        che2.setVisibility(View.GONE);
                        che3.setVisibility(View.GONE);
                        che4.setVisibility(View.GONE);
                        del8.setVisibility(View.GONE);del9.setVisibility(View.GONE);
del10.setVisibility(View.GONE);
        odisha.setVisibility(View.GONE);
        
        jhar1.setVisibility(View.GONE);
tel1.setVisibility(View.GONE);
        mum1.setVisibility(View.GONE);
        up1.setVisibility(View.VISIBLE);
        mum2.setVisibility(View.GONE);
    mum3.setVisibility(View.GONE);
    
  
   kar1.setVisibility(View.GONE);
   kar2.setVisibility(View.GONE);kar3.setVisibility(View.GONE);mum4.setVisibility(View.GONE);vij1.setVisibility(View.GONE); mum5.setVisibility(View.GONE);mum6.setVisibility(View.GONE);mum7.setVisibility(View.GONE);mum8.setVisibility(View.GONE);no.setVisibility(View.GONE);break;
                        case 30:
                        detail.setVisibility(View.VISIBLE);
                        bih1.setVisibility(View.GONE);
                        del1.setVisibility(View.GONE);
                        del2.setVisibility(View.GONE);
                        del3.setVisibility(View.GONE);
                        del4.setVisibility(View.GONE);
                        del5.setVisibility(View.GONE);
                        del6.setVisibility(View.GONE);
                        del7.setVisibility(View.GONE);
                        che1.setVisibility(View.GONE);
                        che2.setVisibility(View.GONE);
                        che3.setVisibility(View.GONE);
                        che4.setVisibility(View.GONE);
                        del8.setVisibility(View.GONE);del9.setVisibility(View.GONE);
del10.setVisibility(View.VISIBLE);

        odisha.setVisibility(View.GONE);
        
        jhar1.setVisibility(View.GONE);
tel1.setVisibility(View.VISIBLE);
        mum1.setVisibility(View.GONE);
        up1.setVisibility(View.GONE);
        mum2.setVisibility(View.GONE);
    mum3.setVisibility(View.GONE);
    
  
   kar1.setVisibility(View.GONE);
   kar2.setVisibility(View.GONE);kar3.setVisibility(View.GONE);mum4.setVisibility(View.GONE);vij1.setVisibility(View.GONE); mum5.setVisibility(View.GONE);mum6.setVisibility(View.GONE);mum7.setVisibility(View.GONE);mum8.setVisibility(View.GONE);no.setVisibility(View.GONE);break;



                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }

        });


        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(meal_provider.this, meal_activity.class);
                startActivity(intent);

            }
        });
    }
    @Override
    public void onBackPressed() {

        finish();
        Intent intent = new Intent(meal_provider.this, meal_activity.class);
        startActivity(intent);

    }
}
