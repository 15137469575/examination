package org.upc.examination.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;

public final class FileUtils {
    public static String downLoad(MultipartFile img,String baseDir){
        String fileName = img.getOriginalFilename();
        String path = baseDir + File.separator + fileName;
        try {
            img.transferTo(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return path;
    }

    /**
     * 创建临时文件
     * @param file
     * @return
     */
    public static File multipartFileToImgFile(MultipartFile file) {
        File targetFile = null;
        if (file.equals("") || file.getSize()<=0){
            return null;
        }else {
            InputStream ins = null;
            try {
                ins = file.getInputStream();
                targetFile = new File(file.getOriginalFilename());
                inputStreamToFile(ins,targetFile);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (ins == null) {
                    return null;
                }else {
                    try {
                        ins.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return targetFile;
    }

    /**
     *
     * 删除临时文件
     * @param file
     */
    public static void deleteTempFile(File file){
        if (file != null){
            File del = new File(file.toURI());
            del.delete();
        }
    }

    private static void inputStreamToFile(InputStream ins, File file){
        OutputStream os = null;
        try {
            os = new FileOutputStream(file);
            int end = 0;
            byte[] buffer = new byte[8192];
            while ((end = ins.read(buffer,0,8192)) != -1){
                os.write(buffer,0,end);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if (ins != null) {
                try {
                    ins.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

}
