package com.mo.base.entity;

/**
 * Created by Moonston on 2017/10/24.
 */
public class SystemDictionaryItem extends BaseEntity {
    private Long parentId;
    private String title;
    private int sequence;

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }
}
