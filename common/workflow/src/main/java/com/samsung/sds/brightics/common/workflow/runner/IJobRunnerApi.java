package com.samsung.sds.brightics.common.workflow.runner;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.samsung.sds.brightics.common.workflow.context.parameter.Parameters;
import com.samsung.sds.brightics.common.workflow.runner.vo.JobParam;
import com.samsung.sds.brightics.common.workflow.runner.vo.JobStatusVO;

public interface IJobRunnerApi {

	//API related to execute job.
	//taskService.executeTask return taskId
	public String executeTask(String taskId, String name, String parameters, String attributes);
	//TaskMessageRepository.isExistFinishMessage
	public boolean isFinishTask(String taskId);
	//messageManager.taskManager().getAsyncTaskResult
	public Object getTaskResult(String taskId);
	//taskService.stopTask
	public void stopTask(String stopTaskId, String functionName, String context);

	//API related to meta data.
	//dataSourceService.getDatasourceInfo
	public Object getDatasourceInfo(String name); //for import data.
	//pyFunctionService.getScriptWithParam
	public String getScriptWithParam(Parameters params); //for ad python function.
	//metadataConverterService.isMetadataRequest
	public boolean isMetadataRequest(JsonObject json); 
	//metadataConverterService.convert
	public JsonElement convert(JsonObject json);
	//JobStatusService.updateJobStatus
	public void updateJobStatus(JobParam jobParam, JobStatusVO jobStatusVO);
	
	//API related to staging data.
	//dataService.getData
	public Object getData(String mid, String tid, long min, long max);
	//dataService.addDataAlias
	public void addDataAlias(String source, String alias);
}