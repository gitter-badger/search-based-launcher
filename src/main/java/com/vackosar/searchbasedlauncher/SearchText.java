package com.vackosar.searchbasedlauncher;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

public class SearchText extends Colorful implements TextWatcher {
    private static final String EMPTY = "";
    private static final String SPACE = " ";
    private static final String REGEX_MATCH_ALL = ".*";
    private final EditText editText;
    private TextChangedCallback textChangedCallback;

    public SearchText (MainActivity mainActivity) {
        editText = (EditText) mainActivity.findViewById(R.id.searchText);
        editText.addTextChangedListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        textChangedCallback.call();
    }

    public void setSearchTextCallback(TextChangedCallback textChangedCallback) {
        this.textChangedCallback = textChangedCallback;
    }

    @Override
    public View getView() {
        return editText;
    }

    public void clearText() {
        editText.setText(EMPTY);
    }

    public void setSpaceCharacterToText() {
        editText.setText(SPACE);
    }

    public String getFilterText () {
        return editText.getText().toString().toLowerCase().replace(SPACE, REGEX_MATCH_ALL) + REGEX_MATCH_ALL;
    }

    public interface TextChangedCallback {
        void call ();
    }
}