package com.accounts;

public class ReadOnlyEvalImpl implements ReadOnlyEval{
    Evaluative e;
    public ReadOnlyEvalImpl(Evaluative e){
        this.e = e;
    }
    @Override
    public int getMarks() {
        return e.getMarksScored();
    }

    @Override
    public int getMaxMarks() {
        return e.getMaxMarks();
    }

    @Override
    public Course getCourse() {
        return e.getCourse();
    }

    @Override
    public int getId() {
        return e.getId();
    }
}
