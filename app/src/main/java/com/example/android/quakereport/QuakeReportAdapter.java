package com.example.android.quakereport;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class QuakeReportAdapter extends ArrayAdapter<QuakeReportDesign>
{
    public QuakeReportAdapter(Activity context, ArrayList<QuakeReportDesign> quakeReport){
        super(context, 0, quakeReport);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.quake_list_item,parent,false);
        }

        //Get the object located at this position in the list
        QuakeReportDesign currentQuakeReport = getItem(position);
        //Get the details from layout
        TextView magnitude, region, time, date, location;
        region = (TextView) convertView.findViewById(R.id.region);
        magnitude = (TextView) convertView.findViewById(R.id.magnitude);
        date = (TextView) convertView.findViewById(R.id.date);
        time = (TextView) convertView.findViewById(R.id.time);
        location = (TextView) convertView.findViewById(R.id.location);
        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitude.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentQuakeReport.getMag());
        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        String reg = currentQuakeReport.getRegion();
        reg.indexOf("f");
        location.setText(reg.substring(0,reg.indexOf("f")+1));
        //Set this text on the region
        region.setText(reg.substring(reg.indexOf("f")+2));
        magnitude.setText(formatMagnitude(currentQuakeReport.getMag()));
        time.setText(currentQuakeReport.getTime());
        date.setText(currentQuakeReport.getDate());
        return convertView;

    }
    private  String formatMagnitude(double magnitude){
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return  magnitudeFormat.format(magnitude);
    }
    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }
    /*
    private int getMagnitudeColor(double magnitude){
        int color = ContextCompat.getColor(getContext(),R.color.magnitude1);
        if(magnitude<2.0){
            color = ContextCompat.getColor(getContext(),R.color.magnitude1);
        }
        else if(magnitude>=2.0&&magnitude<3.0){
            color = ContextCompat.getColor(getContext(),R.color.magnitude2);
        }
        else if(magnitude>=3.0&&magnitude<4.0){
            color = ContextCompat.getColor(getContext(),R.color.magnitude3);
        }
        else if(magnitude>=4.0&&magnitude<5.0){
            color = ContextCompat.getColor(getContext(),R.color.magnitude4);
        }
        else if(magnitude>=5.0&&magnitude<6.0){
            color = ContextCompat.getColor(getContext(),R.color.magnitude5);
        }
        else if(magnitude>=6.0&&magnitude<7.0){
            color = ContextCompat.getColor(getContext(),R.color.magnitude6);
        }
        else if(magnitude>=7.0&&magnitude<8.0){
            color = ContextCompat.getColor(getContext(),R.color.magnitude7);
        }
        else if(magnitude>=8.0&&magnitude<9.0){
            color = ContextCompat.getColor(getContext(),R.color.magnitude8);
        }
        else if(magnitude>=9.0&&magnitude<10.0){
            color = ContextCompat.getColor(getContext(),R.color.magnitude9);
        }
        else if(magnitude>=10.0){
            color = ContextCompat.getColor(getContext(),R.color.magnitude10plus);
        }
        return color;
    }*/
}
