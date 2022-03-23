package com.usta.cafesua.models.services;

import com.usta.cafesua.entities.Status;

import java.util.List;

public interface IStatus {
    public List<Status> findAll();
    public void saveStatus(Status status);
}
