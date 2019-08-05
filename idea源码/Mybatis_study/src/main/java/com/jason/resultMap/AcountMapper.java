package com.jason.resultMap;

import com.jason.Mapper.Acount;
import org.apache.ibatis.annotations.Param;

public interface AcountMapper {




    Acount getAcountById(@Param("acountId") int id);

    Acount getAcountByIdPlus(@Param("acountId") int id);

    Acount getAcountByIdStep(@Param("acountId") int id);
}
