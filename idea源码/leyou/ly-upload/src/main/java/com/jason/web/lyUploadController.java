package com.jason.web;

import com.jason.Enums.ExceptionEnum;
import com.jason.exception.lyException;
import com.jason.service.Uploadservice;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("upload")
public class lyUploadController {

    @Autowired
    private Uploadservice uploadService;

    /**
     * 上传图片功能
     * @param file
     * @return
     */
    @PostMapping("image")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        String url = this.uploadService.upload(file);
        if (StringUtils.isBlank(url)) {
            // url为空，证明上传失败
            throw new lyException(ExceptionEnum.UPLOAD_FAILED_ERROR);
        }
        // 返回200，并且携带url路径
        return ResponseEntity.ok(url);
    }
}
