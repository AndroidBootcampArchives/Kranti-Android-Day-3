package com.change.kranti;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import model.Issue;
import repository.IssueRepository;

import java.util.List;

public class ViewIssuesActivity extends Activity {

    private IssueRepository issueRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.issues);
        issueRepository = new IssueRepository(getApplicationContext());
        LinearLayout layout = (LinearLayout) findViewById(R.id.listofitems);
        List<Issue> issues  = issueRepository.getIssues();
        LayoutInflater layoutInflater = getLayoutInflater();
        for (Issue issue : issues) {
            View view = layoutInflater.inflate(R.layout.issue_item, null);
            TextView titleView = (TextView)view.findViewById(R.id.title);
            titleView.setText(issue.getTitle());
            TextView descriptionView = (TextView)view.findViewById(R.id.description);
            descriptionView.setText(issue.getDescription());
            layout.addView(view);
        }

    }


}
