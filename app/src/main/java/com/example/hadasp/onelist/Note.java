package com.example.hadasp.onelist;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.design.widget.CoordinatorLayout;


/**
 * Created by hadasp on 10/12/2017.
 */

@Entity(tableName = "Notes")
public class Note {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private boolean checked;

    private String body;

    private boolean category0;
    private boolean category1;
    private boolean category2;
    private boolean category3;
    private boolean category4;
    private boolean category5;
    private boolean category6;
    private boolean category7;
    private boolean category8;
    private boolean category9;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean getChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public boolean getCategory0() {
        return category0;
    }
    public void setCategory0(boolean category0) {
        this.category0 = category0;
    }
    public boolean getCategory1() {
        return category1;
    }
    public void setCategory1(boolean category1) {
        this.category1 = category1;
    }
    public boolean getCategory2() {
        return category2;
    }
    public void setCategory2(boolean category2) {
        this.category2 = category2;
    }
    public boolean getCategory3() {
        return category3;
    }
    public void setCategory3(boolean category3) {
        this.category3 = category3;
    }
    public boolean getCategory4() {
        return category4;
    }
    public void setCategory4(boolean category4) {
        this.category4 = category4;
    }
    public boolean getCategory5() {
        return category5;
    }
    public void setCategory5(boolean category5) {
        this.category5 = category5;
    }
    public boolean getCategory6() {
        return category6;
    }
    public void setCategory6(boolean category6) {
        this.category6 = category6;
    }
    public boolean getCategory7() {
        return category7;
    }
    public void setCategory7(boolean category7) {
        this.category7 = category7;
    }
    public boolean getCategory8() {
        return category8;
    }
    public void setCategory8(boolean category8) {
        this.category8 = category8;
    }
    public boolean getCategory9() {
        return category9;
    }
    public void setCategory9(boolean category9) {
        this.category9 = category9;
    }

}
