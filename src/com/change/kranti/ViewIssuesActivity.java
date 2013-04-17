package com.change.kranti;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.*;
import com.change.kranti.adapters.ViewIssuesAdapter;
import model.Issue;
import repository.IssueRepository;

import java.util.List;

public class ViewIssuesActivity extends ListActivity {

    private IssueRepository issueRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.issues);
        issueRepository = new IssueRepository(getApplicationContext());
        ViewIssuesAdapter adapter =new ViewIssuesAdapter(this,R.id.issue_item,R.id.title,issueRepository.getIssues());
        setListAdapter(adapter);

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        TextView viewById =(TextView) v.findViewById(R.id.title);
        Toast.makeText(getApplicationContext(),viewById.getText().toString(),Toast.LENGTH_SHORT).show();
    }
}
