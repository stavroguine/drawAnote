package com.example.ben.drawanote;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class DocRecyclerAdapter extends RecyclerView.Adapter<DocRecyclerAdapter.ViewHolder> {

    private final Context mContext;
    private final List<Doc> mDocs;
    private final LayoutInflater mLayoutInflater;
    public static final String DOC_POSITION = "com.jwhh.jim.notekeeper.NOTE_POSITION";

    public DocRecyclerAdapter(Context context, List<Doc> docs) {
        mContext = context;
        mDocs = docs;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.item_doc_list, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Doc doc = mDocs.get(position);
        holder.mTextTitle.setText(doc.getTitle());
        holder.mCurrentPosition = position;
    }

    @Override
    public int getItemCount() {
        return mDocs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final TextView mTextTitle;
        public int mCurrentPosition;

        public ViewHolder(View itemView) {
            super(itemView);
            mTextTitle = (TextView) itemView.findViewById(R.id.text_title);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, DrawingActivity.class);
                    intent.putExtra(DOC_POSITION, mCurrentPosition);
                    mContext.startActivity(intent);
                }
            });
        }
    }
}







