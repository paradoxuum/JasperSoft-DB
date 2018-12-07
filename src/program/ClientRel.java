package program;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.util.List;

import model.Client;

public class ClientRel {
	private String path;
	private String pathToReportPackage;
	
	public ClientRel() {
		this.path = this.getClass().getClassLoader().getResource("").getPath();
		this.pathToReportPackage = this.path + "program/";
		System.out.println(path);
	}

	public static void imprimir(List<Client> clients) throws Exception {
		JasperReport report = JasperCompileManager.compileReport("./Clients.jrxml");

		JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(clients));

		JasperExportManager.exportReportToPdfFile(print, "./Report.pdf");
	}

	public String getPathToReportPackage() {
		return this.pathToReportPackage;
	}

	public String getPath() {
		return this.path;
	}
}
