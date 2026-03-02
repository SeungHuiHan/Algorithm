select a.APNT_NO,p.PT_NAME,p.PT_NO,a.MCDP_CD,d.DR_NAME,a.APNT_YMD
from  PATIENT p,DOCTOR d,
    (select * 
    from APPOINTMENT
    where APNT_CNCL_YN='N' and date_format(APNT_YMD,'%Y-%m-%d')='2022-04-13' 
    and MCDP_CD='CS') a
where p.PT_NO=a.PT_NO and d.DR_ID=a.MDDR_ID
order by APNT_YMD