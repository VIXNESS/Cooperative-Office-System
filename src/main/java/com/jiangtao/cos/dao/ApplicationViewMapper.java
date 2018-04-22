package com.jiangtao.cos.dao;
import com.jiangtao.cos.pojo.ApplicationView;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ApplicationViewMapper {
    final String getApplicationByViewerPk = "SELECT a.*,office.staff FROM application a INNER JOIN rv_flow flow on a.ptr = flow.pk INNER JOIN atm_tran tran on flow.atm = tran.pk INNER JOIN office office on office.department = tran.rv_dp and office.posi = tran.rv_posi WHERE office.staff =  #{viewerPk};";

    @Select(getApplicationByViewerPk)
    @Results(value = {
            @Result(property = "viewerPk", column = "staff"),
            @Result(property = "apPk", column = "ap_pk"),
            @Result(property = "apActor", column = "ap_actor"),
            @Result(property = "rvPk", column = "rv_pk"),
            @Result(property = "apDate", column = "ap_date"),
            @Result(property = "apComment", column = "ap_comment"),
            @Result(property = "ptr", column = "ptr")
    })
    List<ApplicationView> selectByViewerPk(String viewerPk);
}
