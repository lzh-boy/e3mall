package cn.e3mall.common.utils;

import java.io.IOException;

import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

/**
 * FastDFS 文件上传工具类
 *
 * @author colg
 */
public class FastDFSClient {

	private TrackerClient trackerClient = null;
	private TrackerServer trackerServer = null;
	private StorageServer storageServer = null;
	private StorageClient1 storageClient = null;

	public FastDFSClient(String conf) {
		if (conf.contains("classpath:")) {
			System.out.println(this.getClass().getResource("/").getPath());
			conf = conf.replace("classpath:", this.getClass().getResource("/").getPath());
		}
		try {
			ClientGlobal.init(conf);
			trackerClient = new TrackerClient();
			trackerServer = trackerClient.getConnection();
			storageServer = null;
			storageClient = new StorageClient1(trackerServer, storageServer);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 上传文件方法
	 * <p>
	 * Title: uploadFile
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param fileName
	 *            文件全路径
	 * @param extName
	 *            文件扩展名，不包含（.）
	 * @param metas
	 *            文件扩展信息
	 * @return
	 * @throws Exception
	 */
	public String uploadFile(String fileName, String extName, NameValuePair[] metas) {
		String result = null;
		try {
			return storageClient.upload_file1(fileName, extName, metas);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public String uploadFile(String fileName) {
		return uploadFile(fileName, null, null);
	}

	public String uploadFile(String fileName, String extName) {
		return uploadFile(fileName, extName, null);
	}

	/**
	 * 上传文件方法
	 * <p>
	 * Title: uploadFile
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param fileContent
	 *            文件的内容，字节数组
	 * @param extName
	 *            文件扩展名
	 * @param metas
	 *            文件扩展信息
	 * @return
	 * @throws Exception
	 */
	public String uploadFile(byte[] fileContent, String extName, NameValuePair[] metas) {
		String result = null;
		try {
			result = storageClient.upload_file1(fileContent, extName, metas);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public String uploadFile(byte[] fileContent) {
		return uploadFile(fileContent, null, null);
	}

	public String uploadFile(byte[] fileContent, String extName) {
		return uploadFile(fileContent, extName, null);
	}

	/**
	 * 从存储服务器删除文件
	 * 
	 * @param file_id
	 *            文件ID（包括组名和文件名）
	 * @return 0表示成功，没有表示失败为零（错误代码）
	 */
	public int deleteFile(String file_id) {
		int delete_file1 = 0;
		try {
			delete_file1 = storageClient.delete_file1(file_id);
		} catch (IOException | MyException e) {
			e.printStackTrace();
		}
		return delete_file1;
	}

}
