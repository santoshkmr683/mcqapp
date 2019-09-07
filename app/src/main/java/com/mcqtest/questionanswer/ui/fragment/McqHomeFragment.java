package com.mcqtest.questionanswer.ui.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mcqtest.R;
import com.mcqtest.common.ui.fragment.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class McqHomeFragment extends BaseFragment {

    private TextView mObtainScoreTv;
    private FragmentInteractionListener mFragmentInteractionListener;

    public McqHomeFragment() {
        // Required empty public constructor
    }

    public static McqHomeFragment newInstance() {
        
        Bundle args = new Bundle();
        
        McqHomeFragment fragment = new McqHomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mFragmentInteractionListener = (FragmentInteractionListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().getLocalClassName() +
                    " must implement FragmentInteractionListener");
        }
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setLayout(R.layout.fragment_mcq_home);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    private void initView(View view){
        mObtainScoreTv = view.findViewById(R.id.obtain_score);
        view.findViewById(R.id.start_quiz_btn).setOnClickListener(v -> {
            
            if (mFragmentInteractionListener != null){
                mFragmentInteractionListener.onStartQuizButtonClick();
            }

        });
    }

    public interface FragmentInteractionListener {
        void onStartQuizButtonClick();
    }
}
