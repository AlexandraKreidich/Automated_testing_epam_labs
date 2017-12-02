package entities;

public class Mark {
    private int subjectId;
    private int mark;

    public Mark(int _subjectId, int _mark) {
        this.subjectId = _subjectId;
        this.mark = _mark;
    }

    public int getSubjectId() {
        return this.subjectId;
    }

    public int getMark() {
        return this.mark;
    }

    public void setSubjectId(int _subjectId) {
        this.subjectId = _subjectId;
    }

    public void setMark(int _mark) {
        this.mark = _mark;
    }
}
