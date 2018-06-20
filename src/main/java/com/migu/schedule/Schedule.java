package com.migu.schedule;


import com.migu.schedule.constants.ReturnCodeKeys;
import com.migu.schedule.info.TaskInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
*类名和方法不能修改
 */
public class Schedule{

    //创建服务节点队列
    List<TaskInfo> lists ;

    //创建任务队列
    Map<Integer, Integer> taskMaps;


    //初始化
    public int init() {
        lists = new ArrayList<TaskInfo>();
        taskMaps = new HashMap<Integer, Integer>();
        return ReturnCodeKeys.E001;
    }


    //注册服务节点
    public int registerNode(int nodeId) {

        //服务节点编号非法
        if(nodeId <= 0){
            return ReturnCodeKeys.E004;
        }

        //服务节点已注册
        for(TaskInfo list : lists){

            if(list.getNodeId() == nodeId){
                return ReturnCodeKeys.E005;
            }

        }

        TaskInfo task = new TaskInfo();
        task.setNodeId(nodeId);
        lists.add(task);

        return ReturnCodeKeys.E003;
    }

    //注销服务节点
    public int unregisterNode(int nodeId) {

        //服务节点编号非法
        if(nodeId <= 0){
            return ReturnCodeKeys.E004;
        }

        //服务节点未注册
        for(TaskInfo list : lists){

            int i = 0 ;
            i ++ ;
            if(list.getNodeId() == nodeId){
                TaskInfo task = new TaskInfo();
                task.setNodeId(nodeId);
                lists.remove(task);
                return ReturnCodeKeys.E006;
            }

            if(list.getNodeId() != nodeId){
                if(lists.size() == i ){
                    return ReturnCodeKeys.E007;
                }
                continue;
            }

        }
        return ReturnCodeKeys.E006;

    }

    //添加任务
    public int addTask(int taskId, int consumption) {

        //任务编号非法
        if(taskId <= 0){
            return ReturnCodeKeys.E009;
        }

        //任务已添加
        if(taskMaps.get(taskId) != null ){
            return ReturnCodeKeys.E010;
        }

        //任务添加成功
        taskMaps.put(taskId , consumption);

        return ReturnCodeKeys.E008;
    }

    //删除任务
    public int deleteTask(int taskId) {

        //任务编号非法
        if(taskId <= 0){
            return ReturnCodeKeys.E009;
        }

        //任务不存在
        if(taskMaps.get(taskId) == null ){
            return ReturnCodeKeys.E012;
        }

        //删除任务成功
        taskMaps.remove(taskId);

        return ReturnCodeKeys.E011;
    }

    //任务调度
    public int scheduleTask(int threshold) {
        // TODO 方法未实现
        return ReturnCodeKeys.E000;
    }


    public int queryTaskStatus(List<TaskInfo> tasks) {
        // TODO 方法未实现
        return ReturnCodeKeys.E000;
    }

}
