# Kiuwan_Rules_Remediation
If you are interested in getting the field 'REMEDIATION' of the Rules that detected defects in your application, then you can use this program as template. 

The program obtains all the rules violated in your application via the Kiuwan Rest API and it searches the field Remediation per Rule in an Excel file (xlsx) which contains all the Rules information.

## Previous Steps
First of all, you will have to download a CSV file with all the rules information of your model and export it to xlsx format. For that:

1. Go to Models Management in Kiuwan's Administration Pannel and select your model in use. Click on Rules tab. Next to the title there is a button where you can export the rules as CSV.

2. Open the CSV file with Google Sheets and download it as Microsoft Excel (xlsx). (For more info: https://www.kiuwan.com/docs/display/K5/Cannot+Import+CSV+Kiuwan+Reports+into+Microsoft+Excel#CannotImportCSVKiuwanReportsintoMicrosoftExcel-Problem )

## Running the program
Import the project as a Maven one to get dependencies.

1. The program must receive 4 arguments: username, password, application name and path to Excel file. 
If you need to make changes, you can find Kiuwan Rest API documentation in: https://www.kiuwan.com/docs/display/K5/REST+API

## Output example
```
java -jar Remediation.jar myusername mypassword JuiceShop C:\Users\eboronat\CQM_RULES.xlsx

OPT.JAVASCRIPT.AvoidOctalNumber -> Avoiding bad programming practices causing confusion improves reliability.
OPT.JAVASCRIPT.TooManyBreakOrContinueInLoop -> Avoid unexpected behaviour.
OPT.JAVASCRIPT.DefaultClauseSwitchStatements -> Avoid confusions.
```
