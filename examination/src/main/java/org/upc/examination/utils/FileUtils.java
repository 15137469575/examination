package org.upc.examination.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public final class FileUtils {

    /**
     * 解压zip文件
     * @param fileName
     * @param baseDir
     * @return  返回是否解压成功
     */
    public static boolean unZip(String fileName, String baseDir) {
        boolean flag = false;

        StringBuffer sb = new StringBuffer();
        sb.append(baseDir).append(File.separator).append(fileName);

        // 判断压缩文件是否存在
        File file = new File(sb.toString());
        if (!file.exists()) {
            return flag;
        }

        ZipFile zipFile;
        Enumeration<?> entries;
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            zipFile = new ZipFile(file, Charset.forName("GBK"));
            entries = zipFile.entries();

            while (entries.hasMoreElements()) {
                ZipEntry entry = (ZipEntry) entries.nextElement();
                if (entry.isDirectory()) {
                    String dirPath = baseDir + File.separator + entry.getName();
                    File dirFile = new File(dirPath);
                    dirFile.mkdirs();
                } else {
                    String dirPath = baseDir + File.separator + entry.getName();;
                    File targetFile = new File(dirPath);

                    if (!targetFile.getParentFile().exists()){
                        targetFile.getParentFile().mkdirs();
                    }

                    targetFile.createNewFile();
                    is = zipFile.getInputStream(entry);
                    fos = new FileOutputStream(targetFile);

                    int end = 0;
                    byte[] buffer = new byte[1024];
                    while((end = is.read(buffer)) != -1){
                        fos.write(buffer,0,end);
                    }
                    is.close();
                    fos.close();
                }
            }
            zipFile.close();
            flag = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        file.delete();

        return flag;
    }

    /**
     * 分片文件合并
     *
     * @param fileName 文件名
     * @param baseDir  存储路径
     * @param size     分片个数
     */
    public static boolean mergeFile(String fileName, String baseDir, int size) {
        int index;
        boolean flag = false;
        StringBuffer path = new StringBuffer();
        File[] files = new File[size];

        for (index = 0; index < size; index++) {
            path.append(baseDir).append(File.separator).append(String.valueOf(index)).append("-").append(fileName);
            files[index] = new File(path.toString());
            path.setLength(0);
        }

        FileChannel channel = null;
        FileChannel fileChannel = null;
        FileInputStream fis = null;
        try {
            channel = new FileOutputStream(baseDir + File.separator + fileName).getChannel();
            for (index = 0; index < size; index++) {
                fis = new FileInputStream(files[index]);
                fileChannel = fis.getChannel();
                channel.transferFrom(fileChannel, channel.size(), fileChannel.size());
                fileChannel.close();
                fis.close();
            }

            channel.close();

            for (File tmp : files){
                tmp.delete();
            }

            flag = true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (channel != null) {
                try {
                    channel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileChannel != null) {
                try {
                    fileChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return flag;
    }


    /**
     * MultipartFile下载到本地
     *
     * @param img
     * @param baseDir
     * @return 本地文件地址
     */
    public static String downLoad(MultipartFile img, String baseDir) {
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
     * 
     * @param file
     * @return
     */
    public static File multipartFileToImgFile(MultipartFile file) {
        File targetFile = null;
        if (file.equals("") || file.getSize() <= 0) {
            return null;
        } else {
            InputStream ins = null;
            try {
                ins = file.getInputStream();
                targetFile = new File(file.getOriginalFilename());
                inputStreamToFile(ins, targetFile);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (ins == null) {
                    return null;
                } else {
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
     * 删除临时文件
     *
     * @param file
     */
    public static void deleteTempFile(File file) {
        if (file != null) {
            File del = new File(file.toURI());
            boolean result = del.delete();
        }
    }

    private static void inputStreamToFile(InputStream ins, File file) {
        OutputStream os = null;
        try {
            os = new FileOutputStream(file);
            int end = 0;
            byte[] buffer = new byte[8192];
            while ((end = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, end);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
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
