package com.codefun.questionanswer.ui.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.codefun.R;
import com.codefun.common.ui.fragment.BaseFragment;
import com.codefun.common.util.CodeFunUtil;
import com.codefun.questionanswer.model.InputOutputQuesAns;
import com.codefun.questionanswer.ui.adapter.InputOutputAnswerAdapter;

import java.util.List;

import br.tiagohm.codeview.CodeView;
import br.tiagohm.codeview.HightlightJs;

/**
 * A simple {@link BaseFragment} subclass.
 */
public class InputOutputFragment extends BaseFragment implements
        InputOutputAnswerAdapter.AdapterItemClickListener {

    private TextView mQuestion;
    private CodeView mQuesCode;
    private View mRootLayout;
    private RecyclerView mRecyclerView;
    private List<InputOutputQuesAns> mInputOutputQuesAnsList;

    private String[] serialNo = {"A", "B", "C", "D"};
    private String[] content = {"343123", "265452", "2356456", "3245356"};


    public InputOutputFragment() {
        // Required empty public constructor
    }

    public static InputOutputFragment newInstance() {

        Bundle args = new Bundle();

        InputOutputFragment fragment = new InputOutputFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setLayout(R.layout.fragment_input_output);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        showToolbar();
        setToolbarTitle("Input and Output");
    }

    private void initView(View view) {
        mInputOutputQuesAnsList = CodeFunUtil.getInputOutputQuesAnsList(getContext());
        mRootLayout = view.findViewById(R.id.root_layout);
        mQuestion = view.findViewById(R.id.question_tv);
        mQuesCode = view.findViewById(R.id.code_view);
        mRecyclerView = view.findViewById(R.id.recycler_view);

        mQuestion.setText(mInputOutputQuesAnsList.get(0).getQuesHeading());
        mQuesCode.setSyntaxHighlighter(new HightlightJs())
                .setCode(mInputOutputQuesAnsList.get(0).getQuesCodeBody())
                //HightlightJs.Languages.AUTO is slow!!!
                .setLanguage(HightlightJs.Languages.JAVA)
                .setTheme(HightlightJs.Themes.DEFAULT)
                .setShowLineNumber(false)
                .setTextSize(12)
                .apply();
        setRecyclerViewData();
    }

    private void setRecyclerViewData() {
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(new InputOutputAnswerAdapter(getContext(), mInputOutputQuesAnsList.get(0).getOptionList(), this));
    }

    @Override
    public void onItemClick() {
        Snackbar snackbar = Snackbar.make(mRootLayout, "Correct", Snackbar.LENGTH_LONG);
        snackbar.show();
    }
}
