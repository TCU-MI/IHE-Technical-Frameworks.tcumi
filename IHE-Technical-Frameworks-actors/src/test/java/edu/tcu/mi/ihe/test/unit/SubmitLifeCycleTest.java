package edu.tcu.mi.ihe.test.unit;

import java.io.IOException;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

import edu.tcu.mi.ihe.iti.model.Author;
import edu.tcu.mi.ihe.iti.model.DocumentEntry;
import edu.tcu.mi.ihe.test.ProvideAndRegisterDocumentSetTest;

public class SubmitLifeCycleTest extends ProvideAndRegisterDocumentSetTest {

	
	@Test
	public void test04_APND() {  /** 新文件附加至已存在文件下*/
		String docId = submitOneDocument();
		DocumentEntry document = initOneDocument();
		document.setAppendDocumentId(docId);
	}
	
	@Test
	public void test04_RPLC() {  
		String docId = submitOneDocument();
		DocumentEntry document = initOneDocument();
		document.setReplaceDocumentId(docId);
	}
	
	@Test
	public void test04_XFRM() {  
		String docId = submitOneDocument();
		DocumentEntry document = initOneDocument();
		document.setTransformDocumentId(docId);
	}
	
	@Test
	public void test04_XFRM_RPLC() {  

		String docId = submitOneDocument();
		DocumentEntry document = initOneDocument();
		
		document.setTransformAndReplaceDocumentId(docId);
	}
	
	@Test
	public void test04_Signs() {  
		String docId = submitOneDocument();
		DocumentEntry document = initOneDocument();
		document.setSignatureDocumentId(docId);
	}
	
	private DocumentEntry initOneDocument(){
		DocumentEntry document = metadata.addDocument();
		Author author02 = document.addAuthor();
		author02.addAuthorRole("主治醫師");
		author02.addAuthorPerson("醫師");
		author02.addAuthorInstitution("醫院");
		author02.addAuthorSpecialty("心臟內科醫師");
		
		document.setClassCode("DEMO-Procedure");
		document.setFormatCode("urn:ihe:rad:TEXT");
		document.setHealthcareFacilityTypeCode("281PC2000N");
		document.setPracticeSettingCode("394802001");
		document.setTypeCode("34096-8");
		document.addConfidentialityCode("N");
		document.addEventCodeList("T-D4909");
		document.addEventCodeList("TRID1001");
		
		String filename = "0001k.xml";
		ClassPathResource resource = new ClassPathResource("test_data/" + filename);
		try {
			document.setTitle(filename);
			document.setContentInputStream(resource.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return document;
	}
}
