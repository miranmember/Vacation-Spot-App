package com.example.a3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class ImgFragment extends Fragment {
    private int mCurrIdx = -1;
    private ImageView mQuoteView = null;
    private int mQuoteArrayLen;

    private static final String TAG = "ImgFragment";

    public int getShownIndex() {
        return mCurrIdx;
    }

    public void showQuoteAtIndex(int newIndex) {
        if (newIndex < 0 || newIndex >= mQuoteArrayLen)
            return;
        mCurrIdx = newIndex;
        mQuoteView.setImageResource(MainActivity.img.get(mCurrIdx));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout defined in quote_fragment.xml
        // The last parameter is false because the returned view does not need to be attached to the container ViewGroup
        return inflater.inflate(R.layout.img, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mQuoteView = (ImageView) getActivity().findViewById(R.id.imageView);
        mQuoteArrayLen = MainActivity.img.size();
    }
}
