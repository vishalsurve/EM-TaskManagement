/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.em.emtaskmanagement.dao;

import com.em.emtaskmanagement.model.Task;
import java.util.List;

/**
 *
 * @author vishal
 */
public interface TaskDAO {

    void saveTask(Task task);

    public List<String> taskList();
}
