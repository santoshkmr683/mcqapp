package com.codefun;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import io.github.kbiakov.codeview.CodeView;
import io.github.kbiakov.codeview.adapters.Options;
import io.github.kbiakov.codeview.highlight.ColorTheme;

public class TestActivity extends AppCompatActivity {

    private CodeView codeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        codeView = findViewById(R.id.code_view);
        /*codeView.setCode("package google;\n" +
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
                "}\n");*/
        codeView.setOptions(Options.Default.get(this)
                .withLanguage("java")
                .withCode("package google;\n" +
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
                .withTheme(ColorTheme.DEFAULT));
    }
}
