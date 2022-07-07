package com.livfast.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.livfast.model.LivFastScheme;
import com.livfast.model.LivFastSchemeRequest;
import com.livfast.model.LivFastStateWiseSecondary;
import com.livfast.model.LivFastStateWiseTeritiary;
import com.livfast.repository.LivFastSchemeRepository;
import com.livfast.repository.LivFastStateWiseSecondarySchemeRepository;
import com.livfast.repository.LivFastStateWiseTertiarySchemeRepository;
import com.livguard.model.Scheme;
import com.livguard.model.StateWiseTeritiary;

@Service
@Transactional("secondaryTransactionManager")
public class LivFastSchemeService
{
	private static final Logger log = LoggerFactory.getLogger(LivFastSchemeService.class);
	
	@Autowired
	LivFastSchemeRepository schemeRepository;
	
	@Autowired
	LivFastStateWiseTertiarySchemeRepository stateWiseTertiary;
	
	@Autowired
	LivFastStateWiseSecondarySchemeRepository stateWiseSecondary;
	
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	DateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy");
	DateFormat dateformat1 = new SimpleDateFormat("MM/dd/yyyy");
	
	public List<LivFastScheme> getSchemeList()
	{
		try
		{
			return (List<LivFastScheme>) this.schemeRepository.findAll();
		}
		catch (Exception e) 
		{
			log.error("Exception in Get Scheme List ServiceImpl = {}",e);
		}
		return null;
	}
	
	public String getSecondaryStateList()
	{
		try
		{
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy 00:00:00");
			List<LivFastStateWiseSecondary> list = this.stateWiseSecondary.findAll();
			String state="";
			for(LivFastStateWiseSecondary secondary : list)
			{
				if(secondary.getErickCategory() == 0 && secondary.getFourwCategory() == 0 && secondary.getIbUpsCategory() == 0)
				{
					state = state + secondary.getState() +",";
				}else
				{
					if(secondary.getErickCategory() != 0)
					{
						
						Optional<LivFastScheme> scheme = this.schemeRepository.findById(secondary.getErickCategory());
						if(scheme.get() != null)
						{
							Date date = new Date();
							String d1 = formatter.format(date);
							String d2 = formatter.format(scheme.get().getEndTimestamp());
							int cmpre = d1.compareTo(d2);
							if(cmpre > 0)
							{
								state = state + secondary.getState() +",";
							}
						}
					}else
					if(secondary.getFourwCategory() != 0)
					{
						Optional<LivFastScheme> scheme = this.schemeRepository.findById(secondary.getFourwCategory());
						if(scheme.get() != null)
						{
							Date date = new Date();
							String d1 = formatter.format(date);
							String d2 = formatter.format(scheme.get().getEndTimestamp());
							int cmpre = d1.compareTo(d2);
							if(cmpre > 0)
							{
								state = state + secondary.getState() +",";
							}
						}
					}else if(secondary.getIbUpsCategory() != 0)
					{
						Optional<LivFastScheme> scheme = this.schemeRepository.findById(secondary.getIbUpsCategory());
						if(scheme.get() != null)
						{
							Date date = new Date();
							String d1 = formatter.format(date);
							String d2 = formatter.format(scheme.get().getEndTimestamp());
							if(d1.compareTo(d2) > 0)
							{
								state = state + secondary.getState() +",";
							}
						}
					}
				}
			}
			StringBuffer sb= new StringBuffer(state);  
			sb.deleteCharAt(sb.length()-1); 
			return sb.toString();
		}
		catch (Exception e) 
		{
			log.error("Exception in Get Secondary State List ServiceImpl = {}",e);
		}
		return "";
	}
	
	public String getTeritaryStateList()
	{
		try
		{
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy 00:00:00");
			List<LivFastStateWiseTeritiary> list = this.stateWiseTertiary.findAll();
			String state="";
			for(LivFastStateWiseTeritiary teritiary : list)
			{
				if(teritiary.getErickCategory() == 0 && teritiary.getFourwCategory() == 0 && teritiary.getIbUpsCategory() == 0)
				{
					state = state + teritiary.getState() +",";
				}else
				{
					if(teritiary.getErickCategory() != 0)
					{
						Optional<LivFastScheme> scheme = this.schemeRepository.findById(teritiary.getErickCategory());
						if(scheme.get() != null)
						{
							Date date = new Date();
							String d1 = formatter.format(date);
							String d2 = formatter.format(scheme.get().getEndTimestamp());
							int cmpre = d1.compareTo(d2);
							if(cmpre > 0)
							{
								state = state + teritiary.getState() +",";
							}
						}
					}else
						if(teritiary.getFourwCategory() != 0)
						{
							Optional<LivFastScheme> scheme = this.schemeRepository.findById(teritiary.getFourwCategory());
							if(scheme.get() != null)
							{
								Date date = new Date();
								String d1 = formatter.format(date);
								String d2 = formatter.format(scheme.get().getEndTimestamp());
								int cmpre = d1.compareTo(d2);
								if(cmpre > 0)
								{
									state = state + teritiary.getState() +",";
								}
							}
						}else if(teritiary.getIbUpsCategory() != 0)
						{
							Optional<LivFastScheme> scheme = this.schemeRepository.findById(teritiary.getIbUpsCategory());
							if(scheme.get() != null )
							{
								Date date = new Date();
								String d1 = formatter.format(date);
								String d2 = formatter.format(scheme.get().getEndTimestamp());
								int cmpre = d1.compareTo(d2);
								if(cmpre > 0)
								{
									state = state + teritiary.getState() +",";
								}
							}
						}
				}
			}
			state = state.substring(0, state.length());
			System.out.println("Satte :: "+state);
			return state;
	
		}
		catch (Exception e) 
		{
			log.error("Exception in Get Teritary State List ServiceImpl = {}",e);
		}
		return "";
	}
	
	public List<LivFastSchemeRequest> activeTertiarySchemeList()
	{
		List<LivFastSchemeRequest> schemeRequestList = null;
		try
		{
			List<LivFastScheme>  schemeList = this.schemeRepository.findByschemeDetailContaining("tertiary");
			if(schemeList != null)
			{
				schemeRequestList = new ArrayList<LivFastSchemeRequest>();
				for(LivFastScheme scheme : schemeList)
				{
					LivFastSchemeRequest schemeRequest = new LivFastSchemeRequest();
					schemeRequest.setId(scheme.getId());
					schemeRequest.setSchemeName(scheme.getSchemeName());
					schemeRequest.setSchemeDetail(scheme.getSchemeDetail());
					schemeRequest.setConversionRatio(scheme.getConversionRatio());
					schemeRequest.setIsManual(scheme.getIsManual());
					schemeRequest.setCreatedTimestamp(scheme.getCreatedTimestamp());
					schemeRequest.setStartTimestamp(dateformat1.format(scheme.getStartTimestamp()));
					schemeRequest.setEndTimestamp(dateformat1.format(scheme.getEndTimestamp()));
					schemeRequest.setSchemeScandate(dateformat1.format(scheme.getSchemeScandate()));
					List<LivFastStateWiseTeritiary> tertStateList = this.stateWiseTertiary.findByIbUpsCategoryOrFourwCategoryOrErickCategory(scheme.getId(), scheme.getId(), scheme.getId());
					String state = "";
					boolean ib=false, fw=false, er=false;
					for(LivFastStateWiseTeritiary teritiary :tertStateList)
					{
						state = state + teritiary.getState()+",";
						if(teritiary.getIbUpsCategory() != 0)
							ib = true;
						if(teritiary.getFourwCategory() != 0)
							fw = true;
						if(teritiary.getErickCategory() != 0)
							er = true;
					}				
					schemeRequest.setSchemeState(state);
					schemeRequest.setIbUPS(ib);
					schemeRequest.setFourW(fw);
					schemeRequest.seteRickShaw(er);					
					schemeRequestList.add(schemeRequest);
				}
			}			
			return schemeRequestList;
		}
		catch (Exception e) 
		{
			log.error("Exception in Active Tertiary Scheme List ServiceImpl = {}",e);
		}
		return schemeRequestList;
	}
	
	public List<LivFastSchemeRequest> activeSecondarySchemeList()
	{
		List<LivFastSchemeRequest> schemeRequestList = null;
		try
		{
			List<LivFastScheme>  schemeList = this.schemeRepository.findByschemeDetailContaining("secondary");
			if(schemeList != null)
			{
				schemeRequestList = new ArrayList<LivFastSchemeRequest>();
				for(LivFastScheme scheme : schemeList)
				{
					LivFastSchemeRequest schemeRequest = new LivFastSchemeRequest();
					schemeRequest.setId(scheme.getId());
					schemeRequest.setSchemeName(scheme.getSchemeName());
					schemeRequest.setSchemeDetail(scheme.getSchemeDetail());
					schemeRequest.setConversionRatio(scheme.getConversionRatio());
					schemeRequest.setIsManual(scheme.getIsManual());
					schemeRequest.setCreatedTimestamp(scheme.getCreatedTimestamp());
					schemeRequest.setStartTimestamp(dateformat1.format(scheme.getStartTimestamp()));
					schemeRequest.setEndTimestamp(dateformat1.format(scheme.getEndTimestamp()));
					schemeRequest.setSchemeScandate(dateformat1.format(scheme.getSchemeScandate()));
					List<LivFastStateWiseSecondary> secStateList = this.stateWiseSecondary.findByIbUpsCategoryOrFourwCategoryOrErickCategory(scheme.getId(), scheme.getId(), scheme.getId());
					String state = "";
					boolean ib=false, fw=false, er=false;
					for(LivFastStateWiseSecondary secondary : secStateList)
					{
						state = state + secondary.getState()+",";
						if(secondary.getIbUpsCategory() != 0)
							ib = true;
						if(secondary.getFourwCategory() != 0)
							fw = true;
						if(secondary.getErickCategory() != 0)
							er = true;
					}				
					schemeRequest.setSchemeState(state);
					schemeRequest.setIbUPS(ib);
					schemeRequest.setFourW(fw);
					schemeRequest.seteRickShaw(er);					
					schemeRequestList.add(schemeRequest);
				}
			}			
			return schemeRequestList;
		}
		catch (Exception e) 
		{
			log.error("Exception in Active Secondary Scheme List ServiceImpl = {}",e);
		}
		return null;
	}
	
	public LivFastScheme getScheme(int schemeID)
	{
		try
		{
			Optional<LivFastScheme> op = this.schemeRepository.findById(schemeID);
			return op.get();
		}
		catch (Exception e) 
		{
			log.error("Exception in Get Scheme List ServiceImpl = {}",e);
		}
		return null;
	}
	
	
	
	//saving tertiary
	public String saveScheme(LivFastSchemeRequest schemeRequest)
	{
		try
		{
			System.out.println("I am here in saveScheme try postion");
			LivFastScheme scheme = new LivFastScheme();
			scheme.setSchemeName(schemeRequest.getSchemeName());
			scheme.setSchemeDetail(schemeRequest.getSchemeDetail());
			scheme.setCreatedTimestamp(new Date());
			scheme.setUpdatedTimestamp(new Date());
			scheme.setConversionRatio(1000L);
			scheme.setIsManual("true");
			scheme.setStartTimestamp(dateformat.parse(schemeRequest.getStartTimestamp()));
			scheme.setEndTimestamp(dateformat.parse(schemeRequest.getEndTimestamp()));
			scheme.setSchemeScandate(dateformat.parse(schemeRequest.getSchemeScandate()));
			LivFastScheme ss = this.schemeRepository.save(scheme);
			System.out.println("I am here in saveScheme data saved");
			if(schemeRequest.getSchemeState() != null)
			{
				System.out.println("I am here in saveScheme if portion");
				String[] states = schemeRequest.getSchemeState().trim().split(",");
				if(schemeRequest.getSchemeName().toLowerCase().contains("tertiary scheme") || schemeRequest.getSchemeDetail().toLowerCase().contains("tertiary scheme"))
				{
					for(String state : states)
					{
						LivFastStateWiseTeritiary stateWiseTeritiary = this.stateWiseTertiary.findByState(state.trim().toUpperCase());
						if(stateWiseTeritiary != null)
						{
							stateWiseTeritiary.setErickCategory(0);
							stateWiseTeritiary.setFourwCategory(0);
							stateWiseTeritiary.setIbUpsCategory(0);
							this.stateWiseTertiary.save(stateWiseTeritiary);
							
							if(schemeRequest.geteRickShaw() == true)
								stateWiseTeritiary.setErickCategory(ss.getId());
							if(schemeRequest.getFourW() == true)
								stateWiseTeritiary.setFourwCategory(ss.getId());
							if(schemeRequest.getIbUPS() == true)
								stateWiseTeritiary.setIbUpsCategory(ss.getId());
							this.stateWiseTertiary.save(stateWiseTeritiary);
						}
					}
				}
				else if(schemeRequest.getSchemeName().toLowerCase().contains("secondary scheme") || schemeRequest.getSchemeDetail().toLowerCase().contains("secondary scheme"))
				{
					for(String state : states)
					{
						LivFastStateWiseSecondary stateWiseSecondary = this.stateWiseSecondary.findByState(state.trim().toUpperCase());						
						if(stateWiseSecondary != null)
						{
							System.out.println("I am here in saveScheme state for loop if major portion");
							stateWiseSecondary.setErickCategory(0);
							stateWiseSecondary.setFourwCategory(0);
							stateWiseSecondary.setIbUpsCategory(0);
							this.stateWiseSecondary.save(stateWiseSecondary); 
							
							if(schemeRequest.geteRickShaw() == true)
								stateWiseSecondary.setErickCategory(ss.getId());
							if(schemeRequest.getFourW() == true)
								stateWiseSecondary.setFourwCategory(ss.getId());
							if(schemeRequest.getIbUPS() == true)
								stateWiseSecondary.setIbUpsCategory(ss.getId());
							this.stateWiseSecondary.save(stateWiseSecondary);
						}
					}
				}			
			}			
			return "Success";
			
		}
		catch (Exception e) 
		{
			log.error("Exception in Save Scheme ServiceImpl = {}",e);
		}
		return "Failed";
	}
	
	public String editScheme(LivFastSchemeRequest schemeRequest)
	{
		try
		{
			Optional<LivFastScheme> op = this.schemeRepository.findById(schemeRequest.getId());
			if(op.get() != null)
			{
				LivFastScheme opscheme = op.get();
				opscheme.setSchemeName(schemeRequest.getSchemeName());
				opscheme.setSchemeDetail(schemeRequest.getSchemeDetail());
				opscheme.setCreatedTimestamp(new Date());
				opscheme.setUpdatedTimestamp(new Date());
				opscheme.setConversionRatio(1000L);
				opscheme.setIsManual("true");
				opscheme.setStartTimestamp(dateformat.parse(schemeRequest.getStartTimestamp()));
				opscheme.setEndTimestamp(dateformat.parse(schemeRequest.getEndTimestamp()));
				opscheme.setSchemeScandate(dateformat.parse(schemeRequest.getSchemeScandate()));
				LivFastScheme ss = this.schemeRepository.save(opscheme);
				if(schemeRequest.getSchemeState() != null)
				{
					
					String[] states = schemeRequest.getSchemeState().trim().split(",");
					if(schemeRequest.getSchemeName().toLowerCase().contains("tertiary") || schemeRequest.getSchemeDetail().toLowerCase().contains("tertiary"))
					{
						this.stateWiseTertiary.updateState(schemeRequest.getId());
						for(String state : states)
						{
							LivFastStateWiseTeritiary stateWiseTeritiary = this.stateWiseTertiary.findByState(state.trim().toUpperCase());
							if(stateWiseTeritiary != null)
							{
								stateWiseTeritiary.setErickCategory(0);
								stateWiseTeritiary.setFourwCategory(0);
								stateWiseTeritiary.setIbUpsCategory(0);
								this.stateWiseTertiary.save(stateWiseTeritiary);
								
								if(schemeRequest.geteRickShaw() == true)
									stateWiseTeritiary.setErickCategory(ss.getId());
								if(schemeRequest.getFourW() == true)
									stateWiseTeritiary.setFourwCategory(ss.getId());
								if(schemeRequest.getIbUPS() == true)
									stateWiseTeritiary.setIbUpsCategory(ss.getId());
								this.stateWiseTertiary.save(stateWiseTeritiary);
							}
						}
					}
					else
					{
						this.stateWiseSecondary.updateState(schemeRequest.getId());
						for(String state : states)
						{
							LivFastStateWiseSecondary stateWiseSecondary = this.stateWiseSecondary.findByState(state.trim().toUpperCase());						
							if(stateWiseSecondary != null)
							{
								stateWiseSecondary.setErickCategory(0);
								stateWiseSecondary.setFourwCategory(0);
								stateWiseSecondary.setIbUpsCategory(0);
								this.stateWiseSecondary.save(stateWiseSecondary); 
								
								if(schemeRequest.geteRickShaw() == true)
									stateWiseSecondary.setErickCategory(ss.getId());
								if(schemeRequest.getFourW() == true)
									stateWiseSecondary.setFourwCategory(ss.getId());
								if(schemeRequest.getIbUPS() == true)
									stateWiseSecondary.setIbUpsCategory(ss.getId());
								this.stateWiseSecondary.save(stateWiseSecondary);
							}
						}
					}			
				}			
				return "Success";
			}			
		}
		catch (Exception e) 
		{
			log.error("Exception in Edit Scheme ServiceImpl = {}",e);
		}
		return "Failed";
	}
	
	public String deleteScheme(int schemeID,String schemeType)
	{
		try
		{			
			if(schemeType.equals("Secondary"))
			{
				this.schemeRepository.deleteById(schemeID);
				this.stateWiseSecondary.updateState(schemeID);
			}else if(schemeType.equals("Tertiary"))
			{
				this.schemeRepository.deleteById(schemeID);
				this.stateWiseTertiary.updateState(schemeID);
			}
			return "Success";		
		}
		catch (Exception e) 
		{
			log.error("Exception in Delete Scheme ServiceImpl = {}",e);
		}
		return "Failed";
	}	
}
