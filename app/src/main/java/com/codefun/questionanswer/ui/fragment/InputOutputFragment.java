package com.codefun.questionanswer.ui.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.codefun.R;
import com.codefun.common.ui.fragment.BaseFragment;

import br.tiagohm.codeview.CodeView;
import br.tiagohm.codeview.HightlightJs;

/**
 * A simple {@link BaseFragment} subclass.
 */
public class InputOutputFragment extends BaseFragment {

    private TextView mQuestion;
    private CodeView mQuesCode;
    private View mRootLayout;


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

        mRootLayout = view.findViewById(R.id.root_layout);
        mQuestion = view.findViewById(R.id.question_tv);
        mQuesCode = view.findViewById(R.id.code_view);

        mQuestion.setText("What is Java?");
        mQuesCode.setSyntaxHighlighter(new HightlightJs())
                .setCode("package google;\n" +
                        "\n" +
                        "public class Model {\n" +
                        "\t\n" +
                        "\tString name;\n" +
                        "\tpublic String getName() {\n" +
                        "\t\treturn name;\n" +
                        "\t}\n" +
                        "\tpublic void setName(String name) {\n" +
                        "\t\tthis.name = name;\n" +
                        "\t}\n" +
                        "\tpublic int getRollNo() {\n" +
                        "\t\treturn rollNo;\n" +
                        "\t}\n" +
                        "\tpublic void setRollNo(int rollNo) {\n" +
                        "\t\tthis.rollNo = rollNo;\n" +
                        "\t}\n" +
                        "\tint rollNo;\n" +
                        "\t\n" +
                        "}\n")
                //HightlightJs.Languages.AUTO is slow!!!
                .setLanguage(HightlightJs.Languages.JAVA)
                .setTheme(HightlightJs.Themes.DEFAULT)
                .setShowLineNumber(false)
                .setTextSize(12)
                .apply();

        Snackbar snackbar = Snackbar.make(mRootLayout, "Correct", Snackbar.LENGTH_LONG);
        snackbar.show();
    }
}
