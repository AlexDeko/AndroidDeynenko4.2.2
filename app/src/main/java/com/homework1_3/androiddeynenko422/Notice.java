package com.homework1_3.androiddeynenko422;

import androidx.annotation.NonNull;

public class Notice {
    private String tittle;
    private String subtittle;

    public Notice(String tittle, String subtittle) {
        this.tittle = tittle;
        this.subtittle = subtittle;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getSubtittle() {
        return subtittle;
    }

    public void setSubtittle(String subtittle) {
        this.subtittle = subtittle;
    }

}
