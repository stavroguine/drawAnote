package com.example.ben.drawanote;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;

import java.util.List;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    private DocRecyclerAdapter mDocRecyclerAdapter;
    private DrawItOpenHelper mDbOpenHelper;
    private RecyclerView mRecyclerItems;
    private LinearLayoutManager mDocsLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDbOpenHelper = new DrawItOpenHelper(this);

        initializeDisplayContent();
    }

    @Override
    public void onClick(View view){

    }

    private void initializeDisplayContent() {

        DataManager.loadFromDatabase(mDbOpenHelper);
        /*mRecyclerItems = (RecyclerView) findViewById(R.id.doc_recycler_view);
        mDocsLayoutManager = new LinearLayoutManager(this);


        mDocRecyclerAdapter = new DocRecyclerAdapter(this, null);*/

        final RecyclerView recyclerDocs = (RecyclerView) findViewById(R.id.doc_recycler_view);
        final LinearLayoutManager docsLayoutManager = new LinearLayoutManager(this);
        recyclerDocs.setLayoutManager(docsLayoutManager);

        List<Doc> docs = DataManager.getInstance().getDocs();
        mDocRecyclerAdapter = new DocRecyclerAdapter(this, docs);
        recyclerDocs.setAdapter(mDocRecyclerAdapter);

       /* mRecyclerItems.setAdapter(mDocRecyclerAdapter);*/
    }
}
