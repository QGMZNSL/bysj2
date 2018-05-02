package qxjc.peszp.dao;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import qxjc.peszp.action.WebActionSupport;
import qxjc.peszp.bean.UserBean;

public class doExcalDao extends WebActionSupport{
	public String doExcel() {
		String msg = null;
		PrintWriter out = null;
        BaseDao bd = new BaseDao();
		// 查询对应层次下的所有职位列表
		List<UserBean> tmpSyllabusList = bd.findAllUserList();

		if (tmpSyllabusList == null || tmpSyllabusList.size() == 0) {
			msg = "noData";
		} else {
			// 生成文件
			String excelFileName = "1.xls";
//			String[] paths = service.getPaths();
//			String subPath = service.getConfig("72");
			String excelPhyPath = "D:/ftp/excal"
					+ System.getProperty("file.separator");
			String excelNetPath = "http://192.168.1.55:7001/" + "excal" + "/" + excelFileName;
			// 合成真实的文件名
			String file = "";
			if (excelPhyPath.endsWith(System.getProperty("file.separator"))) {
				file = excelPhyPath + excelFileName;
			} else {
				file = excelPhyPath + System.getProperty("file.separator")
						+ excelFileName;
			}

			File f = new File(file);
			if (!f.exists()) {
				f.getParentFile().mkdirs();
			}

			BufferedOutputStream bos = null;
			WritableWorkbook book = null;
			try {
				bos = new BufferedOutputStream(new FileOutputStream(f));
				book = Workbook.createWorkbook(bos);
				WritableSheet sheet = null;
				ExcelUtil excelUtil = new ExcelUtil(); 
				int pagesize = 1000;
				int rownum = 0;
				Label label = null;
				WritableCellFormat haligncenter = excelUtil.getTitleformat();
				WritableCellFormat alignleft = excelUtil
						.getBodyformatAlignLeft();
				WritableCellFormat alignleftCenter = excelUtil
						.getBodyformatAlignLeftCenter();
				WritableCellFormat aligncenter = excelUtil
						.getBodyformatAlignCenter();
				WritableCellFormat demoleft = excelUtil.getDemoformat();
				String excelTile = "课程设置报表";
				UserBean tmpSyl = null;
				for (int i = 0; i < tmpSyllabusList.size(); i++) {
					if (i % pagesize == 0) {
						// 新建sheet
						sheet = book.createSheet("课程设置报表" + i / pagesize, i
								/ pagesize);
						label = new Label(0, 0, excelTile, haligncenter);
						sheet.addCell(label);
						sheet.mergeCells(0, 0, 7, 0);

						label = new Label(0, 1, "序号", aligncenter);
						sheet.addCell(label);
						label = new Label(1, 1, "课程代码", aligncenter);
						sheet.addCell(label);
						label = new Label(2, 1, "课程名称", aligncenter);
						sheet.addCell(label);
						label = new Label(3, 1, "课程英文名", aligncenter);
						sheet.addCell(label);
						label = new Label(4, 1, "课程分类", aligncenter);
						sheet.addCell(label);
						label = new Label(5, 1, "学分", aligncenter);
						sheet.addCell(label);
						label = new Label(6, 1, "指定教材", aligncenter);
						sheet.addCell(label);
						label = new Label(7, 1, "是否全国统考", aligncenter);
						sheet.addCell(label);

						rownum = 2;
					}

					tmpSyl = tmpSyllabusList.get(i);
					label = new Label(0, rownum, String.valueOf(i + 1),
							alignleftCenter); // 序号
					sheet.addCell(label);
					label = new Label(1, rownum, tmpSyl.getCreateTime(),
							alignleftCenter); // 课程代码
					sheet.addCell(label);
					label = new Label(2, rownum, tmpSyl.getEnable(),
							alignleftCenter); // 课程名称
					sheet.addCell(label);
					label = new Label(3, rownum,
							tmpSyl.getOperater(), alignleftCenter); // 课程英文名
					sheet.addCell(label);
					if ("0".equals(tmpSyl.getOrgName())) { // 专业类型
						label = new Label(4, rownum, "普通课程", alignleftCenter);
					} else if ("1".equals(tmpSyl.getScale())) {
						label = new Label(4, rownum, "实践课程", alignleftCenter);
					} else if ("2".equals(tmpSyl.getUserId())) {
						label = new Label(4, rownum, "论文答辩", alignleftCenter);
					} else {
						label = new Label(4, rownum, " ", alignleftCenter);
					}
					sheet.addCell(label);
					label = new Label(5, rownum, tmpSyl.getUserName(),
							alignleftCenter); // 学分
					sheet.addCell(label);
					label = new Label(6, rownum, tmpSyl.getUserPass(),
							alignleftCenter); // 学分
					sheet.addCell(label);
					label = new Label(7, rownum,
							"1".equals(tmpSyl.getUserType()) ? "是" : "否",
							alignleftCenter); // 是否全国统考
					sheet.addCell(label);

					rownum++;
				}
				book.write();

				msg = "<a href='" + excelNetPath + "' target='_blank'>下载</a>";
			} catch (Exception e) {
				e.printStackTrace();
				msg = "error";
			} finally {
				if (book != null) {
					try {
						book.close();
					} catch (WriteException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (bos != null) {
					try {
						bos.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
System.out.println("111");

		return null;
	}
	
	public static void main(String[] args) {
		doExcalDao ded = new doExcalDao();
		ded.doExcel();
	}

}
