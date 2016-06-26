package yesman.af.softwareengineeringdepartment.cbnu.yesmanapp.View;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import yesman.af.softwareengineeringdepartment.cbnu.yesmanapp.Model.Board;
import yesman.af.softwareengineeringdepartment.cbnu.yesmanapp.R;


/**
 * Created by Jo on 2016-06-23.
 */
public class BoardFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycle, container, false);

        RecyclerView recyclerView=(RecyclerView)view.findViewById(R.id.recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        //리사이클뷰에 보여질 게시판 리스트
        List<Board> items=new ArrayList<>();
        Board[] item=new Board[5];
        item[0]=new Board("#1","애완견 미용 해주실분", new Date(2016,6,3),3,3);
        item[1]=new Board("#2","코딩 해주실분~", new Date(2016,6,4),3,3);
        item[2]=new Board("#3","포토샵 재능 기부해주실 분", new Date(2016,6,1),3,3);
        item[3]=new Board("#4","옷 코디좀 해주세요", new Date(2016,6,6),3,3);

        for(int i=0;i<4;i++) items.add(item[i]);

        recyclerView.setAdapter(new RecyclerAdapter(view.getContext(),items));
        return view;
    }
}
