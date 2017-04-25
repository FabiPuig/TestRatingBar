package com.example.fabian.testratingbar;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private Button btSubmit;
    private RatingBar ratingBar;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        btSubmit = (Button) view.findViewById( R.id.submint_button );
        ratingBar = (RatingBar) view.findViewById( R.id.ratingBar );

        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String rating = String.valueOf( ratingBar.getRating() );

                Toast.makeText( getContext(), rating, Toast.LENGTH_LONG).show();

            }
        });

        return view;
    }
}
