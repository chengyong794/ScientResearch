package com.chengyong.Controller;

import com.chengyong.entity.KProject;
import com.chengyong.mapper.KProjectMapper;
import com.chengyong.mapper.KProjectperMapper;
import com.chengyong.service.KProjectService;
import com.chengyong.util.ExportProjectUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/export")
public class ExportController {
    @Autowired
    private KProjectService kProjectService;

    @Autowired
    private KProjectMapper kProjectMapper;
    /**
     * 导出项目信息
     * @param
     * @return
     */
    @RequestMapping("/exportProject")
    public void exportProject(@Param("pids") Short[] pids, HttpServletResponse response) throws Exception {
        List<String> fieldName = new ArrayList<>();
        fieldName.add("项目名称");
        fieldName.add("项目批次");
        fieldName.add("项目来源");
        fieldName.add("负责人");
        fieldName.add("所在部门");
        fieldName.add("审核状态");

        List<List<String>> fieldData = new ArrayList<>();
        if(pids.length==0||pids==null){
         List<KProject> list = kProjectMapper.listProjectSchool(new KProject());
            for (KProject kp:list
                 ) {
                List<String> data = new ArrayList<>();
                data.add(kp.getPname());
                data.add(kp.getPcname());
                data.add(kp.getPccome());
                data.add(kp.getPpeople());
                data.add(kp.getPdept());
                if(kp.getPsb1()==0){
                    data.add("未审核");
                }else{
                    data.add("已审核");
                }

                fieldData.add(data);
            }
        }else{
            for (int i = 0; i < pids.length; i++) {
                KProject kProject = kProjectService.selectByPrimaryKey(pids[i]);
                List<String> data = new ArrayList<>();
                data.add(kProject.getPname());
                data.add(kProject.getPcname());
                data.add(kProject.getPccome());
                data.add(kProject.getPpeople());
                data.add(kProject.getPdept());
                if(kProject.getPsb1()==0){
                    data.add("未审核");
                }else{
                    data.add("已审核");
                }

                fieldData.add(data);
            }
        }

        String filename = "项目数据.xls";
        ExportProjectUtils exportCustomerUtils = new ExportProjectUtils(fieldName,fieldData);
        //处理中文乱码
        filename = new String(filename.getBytes("utf-8"),"iso-8859-1");
        //响应文件格式
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-disposition", "attachment;filename="+filename);

        //获取输出流
        OutputStream os = response.getOutputStream();
        //生成下载
        exportCustomerUtils.expordExcel(os);

    }

    /**
     * 导出项目信息
     * @param
     * @return
     */
    @RequestMapping("/exportProject2")
    public void exportProject2(@Param("pids") Short[] pids, HttpServletResponse response) throws Exception {
        List<String> fieldName = new ArrayList<>();
        fieldName.add("项目名称");
        fieldName.add("项目批次");
        fieldName.add("项目来源");
        fieldName.add("负责人");
        fieldName.add("所在部门");
        fieldName.add("审核状态");

        List<List<String>> fieldData = new ArrayList<>();
        if(pids.length==0||pids==null){
            List<KProject> list = kProjectMapper.listProject(new KProject());
            for (KProject kp:list
            ) {
                List<String> data = new ArrayList<>();
                data.add(kp.getPname());
                data.add(kp.getPcname());
                data.add(kp.getPccome());
                data.add(kp.getPpeople());
                data.add(kp.getPdept());
                if(kp.getPsb1()==0){
                    data.add("未审核");
                }else{
                    data.add("已审核");
                }

                fieldData.add(data);
            }
        }else{
            for (int i = 0; i < pids.length; i++) {
                KProject kProject = kProjectService.selectByPrimaryKey(pids[i]);
                List<String> data = new ArrayList<>();
                data.add(kProject.getPname());
                data.add(kProject.getPcname());
                data.add(kProject.getPccome());
                data.add(kProject.getPpeople());
                data.add(kProject.getPdept());
                if(kProject.getPsb1()==0){
                    data.add("未审核");
                }else{
                    data.add("已审核");
                }

                fieldData.add(data);
            }
        }

        String filename = "项目数据.xls";
        ExportProjectUtils exportCustomerUtils = new ExportProjectUtils(fieldName,fieldData);
        //处理中文乱码
        filename = new String(filename.getBytes("utf-8"),"iso-8859-1");
        //响应文件格式
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-disposition", "attachment;filename="+filename);

        //获取输出流
        OutputStream os = response.getOutputStream();
        //生成下载
        exportCustomerUtils.expordExcel(os);

    }
}
