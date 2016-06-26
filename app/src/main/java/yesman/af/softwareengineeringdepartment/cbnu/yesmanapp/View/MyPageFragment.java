package yesman.af.softwareengineeringdepartment.cbnu.yesmanapp.View;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import yesman.af.softwareengineeringdepartment.cbnu.yesmanapp.R;


/**
 * Created by Jo on 2016-06-24.
 */
public class MyPageFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_mypage, container, false);

        return rootView;
    }
}
