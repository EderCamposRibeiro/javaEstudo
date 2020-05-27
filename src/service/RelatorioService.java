package service;

import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;

import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.util.JRLoader;

/*1º Passo: Implementar Serializable*/
public class RelatorioService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/*2º Passo: Definir a variável da pasta de relatório*/
	//Pode criar também a variável de subrelatórios
	/*3º Passo: Definir o separador de arquivos*/
	/*Separator são as barras de separação dos arquivos, que dependem do sistema operacional*/
	/*4º Passo: Definir o caminho do arquivo/relatório*/
	/*Caminho do subrelatório*/
	/*5º Passo: Definir o pacote de exportação*/
	/*6º Passo: Definir o arquivo gerado*/	
	private static final String FOLDER_RELATORIOS = "/relatorios";
	private static final String SUBREPORT_DIR = "SUBREPORT_DIR";
	private static String SEPARATOR = File.separator;
	private String caminhoArquivoRelatorio = null;
	private String caminhoSubReport_Dir = "";
	private JRExporter exporter = null;
	private File arquivoGerado = null;
	
	/*7º Passo: Criar o método que vai gerar o relatório*/
	/*          retorna o caminho do arquivo gerado     */
    public String gerarRelatorio(List<?> listaDataBeanCollection, HashMap parametrosRelatorio 
    	 , String nomeRelatirioJasper, String nomeRelatorioSaida, ServletContext servletContext, String tipoEportar) throws Exception {
		
    	/*Cria a lista de collectionDataSource de beans  que carregam os dados para o relatório*/
    	JRBeanCollectionDataSource jrbcds = new JRBeanCollectionDataSource(listaDataBeanCollection);
    	
    	/*Fornece o caminho físico até a pasta que contém os relatórios .jasper*/
    	String caminhoRelatorio = servletContext.getRealPath(FOLDER_RELATORIOS);
    	
    	/*Montar o arquivo*/
    	File file = new File(caminhoRelatorio + SEPARATOR + nomeRelatirioJasper + ".jasper");
    	
    	if (caminhoRelatorio == null 
    			|| (caminhoRelatorio != null && caminhoRelatorio.isEmpty())
    			|| !file.exists()) {
			caminhoRelatorio = this.getClass().getResource(FOLDER_RELATORIOS).getPath();
			SEPARATOR = "";
		}
    	
    	/*Caminho para imagens*/
    	parametrosRelatorio.put("REPORT_PARAMETERS_IMG", caminhoRelatorio);
    	
    	/*Caminho completo até o relatório compilado indicado*/
    	String caminhoArquivosJasper = caminhoRelatorio + SEPARATOR + nomeRelatirioJasper + ".jasper";
    	
    	/*Faz o carregamento de relatório*/
    	JasperReport relatorioJasper = (JasperReport) JRLoader.loadObjectFromFile(caminhoArquivosJasper);
    	
    	/*Seta parametros SUBREPORT_DIR com o caminho físico para subreport*/
    	caminhoSubReport_Dir = caminhoRelatorio + SEPARATOR;
    	parametrosRelatorio.put(SUBREPORT_DIR, caminhoSubReport_Dir);
    	
    	/*Carrega o arquivo*/
    	JasperPrint impressoraJasper = JasperFillManager.fillReport(relatorioJasper, parametrosRelatorio, jrbcds);
    	
    	if (tipoEportar.equalsIgnoreCase("pdf")) {
    		exporter = new JRPdfExporter();
		} else if (tipoEportar.equalsIgnoreCase("xls")) {
	    	exporter = new JRXlsExporter();			
		}
    	
    	/*Caminho do relatório exportado*/
    	caminhoArquivoRelatorio = caminhoRelatorio + SEPARATOR + nomeRelatorioSaida + "." + tipoEportar;
    	
    	/*Criar novo arquivo exportado*/
    	arquivoGerado = new File(caminhoArquivoRelatorio);
    	
    	/*Prepara a impressão*/
    	exporter.setParameter(JRExporterParameter.JASPER_PRINT, impressoraJasper);
    	
    	exporter.setParameter(JRExporterParameter.OUTPUT_FILE, arquivoGerado);
    	
    	/*Executa a exportação*/
    	exporter.exportReport();
    	
    	/*Remove o arquivo do servidor após ser feito o dowload*/
    	arquivoGerado.deleteOnExit();
    	
    	return caminhoArquivoRelatorio;
	}	
	
	
    
    
    
    
	
}
