To run and debug code, download your function code and AWS SAM template and use the SAM CLI in a local IDE. For more information, see Introduction to testing with sam local invoke. You can also export your code to Infrastructure Composer to design a serverless application using your function. For more information, see Using AWS Lambda with AWS Infrastructure Composer.


Download code and SAM template

Export to Infrastructure Composer

  import json
import boto3

def lambda_handler(event, context):
    sns_message = event['Records'][0]['Sns']['Message']
    alarm = json.loads(sns_message)

    alarm_name = alarm['AlarmName']
    reason = alarm['NewStateReason']
    time = alarm['StateChangeTime']
    instance = alarm['Trigger']['Dimensions'][0]['value']

    subject = f"[ALERT] {alarm_name} on {instance}"
    message = f"Alarm triggered: {alarm_name}\nReason: {reason}\nTime: {time}\nInstance: {instance}"

    # Send this message to another SNS or SES
    sns = boto3.client('sns')
    sns.publish(
        TopicArn='ARN
arn:aws:sns:us-east-1:563003501456:taskMonitorNew',
        Subject=subject,
        Message=message
    )
    return {
        'statusCode': 200,
        'body': 'Custom message sent .'
    }



{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Effect": "Allow",
      "Action": "s3:GetObject",
      "Resource": "arn:aws:s3:::prodiadstack-subsystemsn-idemergedatabucketd489dd-19on3kcseark9/*"
    }
  ]
}




This XML file does not appear to have any style information associated with it. The document tree is shown below.
<Error>
<Code>NoSuchBucket</Code>
<Message>The specified bucket does not exist</Message>
<BucketName>prodiadstack-subsystemsn-idemergedatabucketd489dd-19on3kcseark9.s3.us-east-1.amazonaws.com.</BucketName>
<RequestId>KSX3G343KPZRRWCT</RequestId>
<HostId>W/NB4qT9o0FzO+3IjeO/o6kNVzDn+xsmeUhikEoViS0kONbk1PSpnBo+i2f/2M4+0tRVZV/u5us=</HostId>
</Error>

Your browser may be blocking requests to prodiadstack-subsystemsn-idemergedatabucketd489dd-19on3kcseark9.s3.us-east-1.amazonaws.com. Lambda uses this presigned URL to securely store your code changes before updating your function. Check your browser's security settings.



import json
import boto3

def lambda_handler(event, context):
    sns_message = event['Records'][0]['Sns']['Message']
    alarm = json.loads(sns_message)

    alarm_name = alarm['AlarmName']
    reason = alarm['NewStateReason']
    time = alarm['StateChangeTime']
    instance = alarm['Trigger']['Dimensions'][0]['value']

    subject = f"[ALERT] {alarm_name} on {instance}"
    message = f"Alarm triggered: {alarm_name}\nReason: {reason}\nTime: {time}\nInstance: {instance}"

    # Send this message to another SNS or SES
    sns = boto3.client('sns')
    sns.publish(
        TopicArn='arn:aws:sns:your-region:your-topic-id:CustomAlertTopic',
        Subject=subject,
        Message=message
    )
    return {
        'statusCode': 200,
        'body': 'Custom message sent.'
    }





📄 CloudWatch Logs + SNS Email Notification Setup for Windows Task Scheduler Errors
🔧 1. CloudWatch Agent Installation (Windows EC2)
Download and Install Agent:
powershell
CopyEdit
Invoke-WebRequest https://s3.amazonaws.com/amazoncloudwatch-agent/windows/amd64/latest/AmazonCloudWatchAgent.zip -OutFile "C:\Temp\AmazonCloudWatchAgent.zip"
Expand-Archive -Path "C:\Temp\AmazonCloudWatchAgent.zip" -DestinationPath "C:\Program Files\Amazon\AmazonCloudWatchAgent"
Install the agent:
powershell
CopyEdit
cd "C:\Program Files\Amazon\AmazonCloudWatchAgent"
.\install.ps1

🔐 2. IAM Role Permissions
Attach the following policies to the EC2 instance role:
CloudWatchAgentServerPolicy
AmazonSSMManagedInstanceCore (optional for Systems Manager control)
AmazonSNSFullAccess (for SNS testing)
You added it manually via the IAM console.

🛠️ 3. Create config.json for CloudWatch Agent
Path: C:\Program Files\Amazon\AmazonCloudWatchAgent\config.json
json
CopyEdit
{
  "logs": {
    "logs_collected": {
      "windows_events": {
        "collect_list": [
          {
            "event_name": "Microsoft-Windows-TaskScheduler/Operational",
            "levels": ["ERROR", "WARNING"]
          }
        ]
      }
    },
    "log_stream_name": "task-scheduler-errors",
    "log_group_name": "task-scheduler-events"
  }
}
⚠️ You had to create this as a regular user due to limited admin rights.

🚀 4. Start the Agent with Config
powershell
CopyEdit
cd "C:\Program Files\Amazon\AmazonCloudWatchAgent"
.\amazon-cloudwatch-agent-ctl.ps1 -a fetch-config -m ec2 -c file:"C:\Program Files\Amazon\AmazonCloudWatchAgent\config.json" -s
✅ You verified the config is valid and agent started successfully.

📈 5. Create Metric Filter for Error/Warning Events
Go to CloudWatch → Log groups → task-scheduler-events
Select → “Create Metric Filter”
Pattern: ruby CopyEdit   ?ERROR ?Warning
  
Metric name: ErrorWarningEvents
Namespace: TaskScheduler
Metric value: 1

🚨 6. Create CloudWatch Alarm
Go to CloudWatch → Alarms → Create Alarm
Choose:
Metric Namespace: TaskScheduler
Metric: ErrorWarningEvents
Condition: Whenever value ≥ 1
Select SNS topic (created in next step)

📬 7. Create SNS Topic and Email Subscription
Create SNS Topic:
Go to SNS → Topics → Create topic
Name: task-scheduler-alerts
Type: Standard
Create Subscription:
Go to the created topic
Create Subscription
Protocol: Email
Endpoint: your email
✅ Confirm the subscription from your email inbox.

🧪 8. Testing Setup
Go to Task Scheduler → Create Task → name it FailingTaskTest
Set action as: text CopyEdit   Start a program → C:\DoesNotExist\fail.exe
  
Run it manually. It will log an Error.
CloudWatch Agent sends the log.
Metric filter → triggers alarm → SNS sends email ✅

Let me know if you want this exported to a .md or .pdf, or want to continue with enhancements (like multiple log sources or Slack alerting).






Message

There are older events to load. 
Load more.
<Event xmlns='http://schemas.microsoft.com/win/2004/08/events/event'><System><Provider Name='Microsoft-Windows-TaskScheduler' Guid='{de7b24ea-73c8-4a09-985d-5bdadcfa9017}'/><EventID>203</EventID><Version>0</Version><Level>2</Level><Task>203</Task><Opcode>101</Opcode><Keywords>0x8000000000000000</Keywords><TimeCreated SystemTime='2025-04-08T12:14:15.6451597Z'/><EventRecordID>2340818</EventRecordID><Correlation ActivityID='{53b132f6-d864-48e1-8d06-26a84457fb9a}'/><Execution ProcessID='1496' ThreadID='8832'/><Channel>Microsoft-Windows-TaskScheduler/Operational</Channel><Computer>appcompl04d.its.corp.gwl.com</Computer><Security UserID='S-1-5-18'/></System><EventData Name='ActionLaunchFailure'><Data Name='TaskName'>\FailingTask</Data><Data Name='TaskInstanceId'>{53b132f6-d864-48e1-8d06-26a84457fb9a}</Data><Data Name='ActionName'>c:\DoestNotExist\fail.exe</Data><Data Name='ResultCode'>2147942402</Data></EventData><RenderingInfo Culture='en-US'><Message>Task Scheduler failed to launch action "c:\DoestNotExist\fail.exe" in instance "{53b132f6-d864-48e1-8d06-26a84457fb9a}" of task "\FailingTask". Additional Data: Error Value: 2147942402.</Message><Level>Error</Level><Task>Action failed to start</Task><Opcode>Launch Failure</Opcode><Channel>Operational</Channel><Provider>Microsoft-Windows-TaskScheduler</Provider><Keywords></Keywords></RenderingInfo></Event>
<Event xmlns='http://schemas.microsoft.com/win/2004/08/events/event'><System><Provider Name='Microsoft-Windows-TaskScheduler' Guid='{de7b24ea-73c8-4a09-985d-5bdadcfa9017}'/><EventID>101</EventID><Version>0</Version><Level>2</Level><Task>101</Task><Opcode>101</Opcode><Keywords>0x8000000000000001</Keywords><TimeCreated SystemTime='2025-04-08T12:14:15.6455212Z'/><EventRecordID>2340819</EventRecordID><Correlation/><Execution ProcessID='1496' ThreadID='8832'/><Channel>Microsoft-Windows-TaskScheduler/Operational</Channel><Computer>appcompl04d.its.corp.gwl.com</Computer><Security UserID='S-1-5-18'/></System><EventData Name='TaskStartFailedEvent'><Data Name='TaskName'>\FailingTask</Data><Data Name='UserContext'>IND\chnksv</Data><Data Name='ResultCode'>2147942402</Data></EventData><RenderingInfo Culture='en-US'><Message>Task Scheduler failed to start "\FailingTask" task for user "IND\chnksv". Additional Data: Error Value: 2147942402.</Message><Level>Error</Level><Task>Task Start Failed</Task><Opcode>Launch Failure</Opcode><Channel>Operational</Channel><Provider>Microsoft-Windows-TaskScheduler</Provider><Keywords></Keywords></RenderingInfo></Event>
<Event xmlns='http://schemas.microsoft.com/win/2004/08/events/event'><System><Provider Name='Microsoft-Windows-TaskScheduler' Guid='{de7b24ea-73c8-4a09-985d-5bdadcfa9017}'/><EventID>203</EventID><Version>0</Version><Level>2</Level><Task>203</Task><Opcode>101</Opcode><Keywords>0x8000000000000000</Keywords><TimeCreated SystemTime='2025-04-08T12:14:34.3302739Z'/><EventRecordID>2340821</EventRecordID><Correlation ActivityID='{c1329d16-370b-457b-ba6f-84a06cf20e30}'/><Execution ProcessID='1496' ThreadID='8832'/><Channel>Microsoft-Windows-TaskScheduler/Operational</Channel><Computer>appcompl04d.its.corp.gwl.com</Computer><Security UserID='S-1-5-18'/></System><EventData Name='ActionLaunchFailure'><Data Name='TaskName'>\FailingTask</Data><Data Name='TaskInstanceId'>{c1329d16-370b-457b-ba6f-84a06cf20e30}</Data><Data Name='ActionName'>c:\DoestNotExist\fail.exe</Data><Data Name='ResultCode'>2147942402</Data></EventData><RenderingInfo Culture='en-US'><Message>Task Scheduler failed to launch action "c:\DoestNotExist\fail.exe" in instance "{c1329d16-370b-457b-ba6f-84a06cf20e30}" of task "\FailingTask". Additional Data: Error Value: 2147942402.</Message><Level>Error</Level><Task>Action failed to start</Task><Opcode>Launch Failure</Opcode><Channel>Operational</Channel><Provider>Microsoft-Windows-TaskScheduler</Provider><Keywords></Keywords></RenderingInfo></Event>
<Event xmlns='http://schemas.microsoft.com/win/2004/08/events/event'><System><Provider Name='Microsoft-Windows-TaskScheduler' Guid='{de7b24ea-73c8-4a09-985d-5bdadcfa9017}'/><EventID>101</EventID><Version>0</Version><Level>2</Level><Task>101</Task><Opcode>101</Opcode><Keywords>0x8000000000000001</Keywords><TimeCreated SystemTime='2025-04-08T12:14:34.3304118Z'/><EventRecordID>2340822</EventRecordID><Correlation/><Execution ProcessID='1496' ThreadID='8832'/><Channel>Microsoft-Windows-TaskScheduler/Operational</Channel><Computer>appcompl04d.its.corp.gwl.com</Computer><Security UserID='S-1-5-18'/></System><EventData Name='TaskStartFailedEvent'><Data Name='TaskName'>\FailingTask</Data><Data Name='UserContext'>IND\chnksv</Data><Data Name='ResultCode'>2147942402</Data></EventData><RenderingInfo Culture='en-US'><Message>Task Scheduler failed to start "\FailingTask" task for user "IND\chnksv". Additional Data: Error Value: 2147942402.</Message><Level>Error</Level><Task>Task Start Failed</Task><Opcode>Launch Failure</Opcode><Channel>Operational</Channel><Provider>Microsoft-Windows-TaskScheduler</Provider><Keywords></Keywords></RenderingInfo></Event>
<Event xmlns='http://schemas.microsoft.com/win/2004/08/events/event'><System><Provider Name='Microsoft-Windows-TaskScheduler' Guid='{de7b24ea-73c8-4a09-985d-5bdadcfa9017}'/><EventID>202</EventID><Version>1</Version><Level>2</Level><Task>202</Task><Opcode>102</Opcode><Keywords>0x8000000000000000</Keywords><TimeCreated SystemTime='2025-04-08T12:20:51.2494218Z'/><EventRecordID>2340839</EventRecordID><Correlation ActivityID='{195ea841-acb7-4a6a-8a66-c0fdeca4eec5}'/><Execution ProcessID='1496' ThreadID='7216'/><Channel>Microsoft-Windows-TaskScheduler/Operational</Channel><Computer>appcompl04d.its.corp.gwl.com</Computer><Security UserID='S-1-5-18'/></System><EventData Name='ActionFailure'><Data Name='TaskName'>\Microsoft\Windows\CertificateServicesClient\KeyPreGenTask</Data><Data Name='TaskInstanceId'>{195ea841-acb7-4a6a-8a66-c0fdeca4eec5}</Data><Data Name='ActionName'>NGC Pregeneration Task Handler</Data><Data Name='ResultCode'>2148073520</Data><Data Name='EnginePID'>4860</Data></EventData><RenderingInfo Culture='en-US'><Message>Task Scheduler failed to complete task "\Microsoft\Windows\CertificateServicesClient\KeyPreGenTask" , instance "{195ea841-acb7-4a6a-8a66-c0fdeca4eec5}" , action "NGC Pregeneration Task Handler" . Additional Data: Error Value: 2148073520.</Message><Level>Error</Level><Task>Action failed</Task><Opcode>Run Failure</Opcode><Channel>Operational</Channel><Provider>Microsoft-Windows-TaskScheduler</Provider><Keywords></Keywords></RenderingInfo></Event>
<Event xmlns='http://schemas.microsoft.com/win/2004/08/events/event'><System><Provider Name='Microsoft-Windows-TaskScheduler' Guid='{de7b24ea-73c8-4a09-985d-5bdadcfa9017}'/><EventID>103</EventID><Version>0</Version><Level>2</Level><Task>103</Task><Opcode>102</Opcode><Keywords>0x8000000000000001</Keywords><TimeCreated SystemTime='2025-04-08T12:20:51.2494238Z'/><EventRecordID>2340840</EventRecordID><Correlation ActivityID='{195ea841-acb7-4a6a-8a66-c0fdeca4eec5}'/><Execution ProcessID='1496' ThreadID='7216'/><Channel>Microsoft-Windows-TaskScheduler/Operational</Channel><Computer>appcompl04d.its.corp.gwl.com</Computer><Security UserID='S-1-5-18'/></System><EventData Name='TaskFailureEvent'><Data Name='TaskName'>\Microsoft\Windows\CertificateServicesClient\KeyPreGenTask</Data><Data Name='InstanceId'>{195ea841-acb7-4a6a-8a66-c0fdeca4eec5}</Data><Data Name='UserContext'>NT AUTHORITY\SYSTEM</Data><Data Name='ResultCode'>2148073520</Data></EventData><RenderingInfo Culture='en-US'><Message>Task Scheduler failed to start instance "{195ea841-acb7-4a6a-8a66-c0fdeca4eec5}" of "\Microsoft\Windows\CertificateServicesClient\KeyPreGenTask"  task for user "NT AUTHORITY\SYSTEM" . Additional Data: Error Value: 2148073520.</Message><Level>Error</Level><Task>Action start failed</Task><Opcode>Run Failure</Opcode><Channel>Operational</Channel><Provider>Microsoft-Windows-TaskScheduler</Provider><Keywords></Keywords></RenderingInfo></Event>
<Event xmlns='http://schemas.microsoft.com/win/2004/08/events/event'><System><Provider Name='Microsoft-Windows-TaskScheduler' Guid='{de7b24ea-73c8-4a09-985d-5bdadcfa9017}'/><EventID>203</EventID><Version>0</Version><Level>2</Level><Task>203</Task><Opcode>101</Opcode><Keywords>0x8000000000000000</Keywords><TimeCreated SystemTime='2025-04-08T12:56:55.6189454Z'/><EventRecordID>2340916</EventRecordID><Correlation ActivityID='{beaa1c1e-3343-4db7-b078-d180d27cb678}'/><Execution ProcessID='1496' ThreadID='9628'/><Channel>Microsoft-Windows-TaskScheduler/Operational</Channel><Computer>appcompl04d.its.corp.gwl.com</Computer><Security UserID='S-1-5-18'/></System><EventData Name='ActionLaunchFailure'><Data Name='TaskName'>\FailingTask</Data><Data Name='TaskInstanceId'>{beaa1c1e-3343-4db7-b078-d180d27cb678}</Data><Data Name='ActionName'>c:\DoestNotExist\fail.exe</Data><Data Name='ResultCode'>2147942402</Data></EventData><RenderingInfo Culture='en-US'><Message>Task Scheduler failed to launch action "c:\DoestNotExist\fail.exe" in instance "{beaa1c1e-3343-4db7-b078-d180d27cb678}" of task "\FailingTask". Additional Data: Error Value: 2147942402.</Message><Level>Error</Level><Task>Action failed to start</Task><Opcode>Launch Failure</Opcode><Channel>Operational</Channel><Provider>Microsoft-Windows-TaskScheduler</Provider><Keywords></Keywords></RenderingInfo></Event>
<Event xmlns='http://schemas.microsoft.com/win/2004/08/events/event'><System><Provider Name='Microsoft-Windows-TaskScheduler' Guid='{de7b24ea-73c8-4a09-985d-5bdadcfa9017}'/><EventID>101</EventID><Version>0</Version><Level>2</Level><Task>101</Task><Opcode>101</Opcode><Keywords>0x8000000000000001</Keywords><TimeCreated SystemTime='2025-04-08T12:56:55.6190863Z'/><EventRecordID>2340917</EventRecordID><Correlation/><Execution ProcessID='1496' ThreadID='9628'/><Channel>Microsoft-Windows-TaskScheduler/Operational</Channel><Computer>appcompl04d.its.corp.gwl.com</Computer><Security UserID='S-1-5-18'/></System><EventData Name='TaskStartFailedEvent'><Data Name='TaskName'>\FailingTask</Data><Data Name='UserContext'>IND\chnksv</Data><Data Name='ResultCode'>2147942402</Data></EventData><RenderingInfo Culture='en-US'><Message>Task Scheduler failed to start "\FailingTask" task for user "IND\chnksv". Additional Data: Error Value: 2147942402.</Message><Level>Error</Level><Task>Task Start Failed</Task><Opcode>Launch Failure</Opcode><Channel>Operational</Channel><Provider>Microsoft-Windows-TaskScheduler</Provider><Keywords></Keywords></RenderingInfo></Event>
<Event xmlns='http://schemas.microsoft.com/win/2004/08/events/event'><System><Provider Name='Microsoft-Windows-TaskScheduler' Guid='{de7b24ea-73c8-4a09-985d-5bdadcfa9017}'/><EventID>203</EventID><Version>0</Version><Level>2</Level><Task>203</Task><Opcode>101</Opcode><Keywords>0x8000000000000000</Keywords><TimeCreated SystemTime='2025-04-08T12:57:34.3432083Z'/><EventRecordID>2340919</EventRecordID><Correlation ActivityID='{b4c4747d-db8e-4ea8-b3d1-baaf33f8c4a5}'/><Execution ProcessID='1496' ThreadID='9628'/><Channel>Microsoft-Windows-TaskScheduler/Operational</Channel><Computer>appcompl04d.its.corp.gwl.com</Computer><Security UserID='S-1-5-18'/></System><EventData Name='ActionLaunchFailure'><Data Name='TaskName'>\FailingTask</Data><Data Name='TaskInstanceId'>{b4c4747d-db8e-4ea8-b3d1-baaf33f8c4a5}</Data><Data Name='ActionName'>c:\DoestNotExist\fail.exe</Data><Data Name='ResultCode'>2147942402</Data></EventData><RenderingInfo Culture='en-US'><Message>Task Scheduler failed to launch action "c:\DoestNotExist\fail.exe" in instance "{b4c4747d-db8e-4ea8-b3d1-baaf33f8c4a5}" of task "\FailingTask". Additional Data: Error Value: 2147942402.</Message><Level>Error</Level><Task>Action failed to start</Task><Opcode>Launch Failure</Opcode><Channel>Operational</Channel><Provider>Microsoft-Windows-TaskScheduler</Provider><Keywords></Keywords></RenderingInfo></Event>
<Event xmlns='http://schemas.microsoft.com/win/2004/08/events/event'><System><Provider Name='Microsoft-Windows-TaskScheduler' Guid='{de7b24ea-73c8-4a09-985d-5bdadcfa9017}'/><EventID>101</EventID><Version>0</Version><Level>2</Level><Task>101</Task><Opcode>101</Opcode><Keywords>0x8000000000000001</Keywords><TimeCreated SystemTime='2025-04-08T12:57:34.3433524Z'/><EventRecordID>2340920</EventRecordID><Correlation/><Execution ProcessID='1496' ThreadID='9628'/><Channel>Microsoft-Windows-TaskScheduler/Operational</Channel><Computer>appcompl04d.its.corp.gwl.com</Computer><Security UserID='S-1-5-18'/></System><EventData Name='TaskStartFailedEvent'><Data Name='TaskName'>\FailingTask</Data><Data Name='UserContext'>IND\chnksv</Data><Data Name='ResultCode'>2147942402</Data></EventData><RenderingInfo Culture='en-US'><Message>Task Scheduler failed to start "\FailingTask" task for user "IND\chnksv". Additional Data: Error Value: 2147942402.</Message><Level>Error</Level><Task>Task Start Failed</Task><Opcode>Launch Failure</Opcode><Channel>Operational</Channel><Provider>Microsoft-Windows-TaskScheduler</Provider><Keywords></Keywords></RenderingInfo></Event>
<Event xmlns='http://schemas.microsoft.com/win/2004/08/events/event'><System><Provider Name='Microsoft-Windows-TaskScheduler' Guid='{de7b24ea-73c8-4a09-985d-5bdadcfa9017}'/><EventID>203</EventID><Version>0</Version><Level>2</Level><Task>203</Task><Opcode>101</Opcode><Keywords>0x8000000000000000</Keywords><TimeCreated SystemTime='2025-04-08T12:57:44.3821082Z'/><EventRecordID>2340922</EventRecordID><Correlation ActivityID='{4692d5c7-d77e-42dc-8ac0-df4a5e4c59cf}'/><Execution ProcessID='1496' ThreadID='9628'/><Channel>Microsoft-Windows-TaskScheduler/Operational</Channel><Computer>appcompl04d.its.corp.gwl.com</Computer><Security UserID='S-1-5-18'/></System><EventData Name='ActionLaunchFailure'><Data Name='TaskName'>\FailingTask</Data><Data Name='TaskInstanceId'>{4692d5c7-d77e-42dc-8ac0-df4a5e4c59cf}</Data><Data Name='ActionName'>c:\DoestNotExist\fail.exe</Data><Data Name='ResultCode'>2147942402</Data></EventData><RenderingInfo Culture='en-US'><Message>Task Scheduler failed to launch action "c:\DoestNotExist\fail.exe" in instance "{4692d5c7-d77e-42dc-8ac0-df4a5e4c59cf}" of task "\FailingTask". Additional Data: Error Value: 2147942402.</Message><Level>Error</Level><Task>Action failed to start</Task><Opcode>Launch Failure</Opcode><Channel>Operational</Channel><Provider>Microsoft-Windows-TaskScheduler</Provider><Keywords></Keywords></RenderingInfo></Event>
<Event xmlns='http://schemas.microsoft.com/win/2004/08/events/event'><System><Provider Name='Microsoft-Windows-TaskScheduler' Guid='{de7b24ea-73c8-4a09-985d-5bdadcfa9017}'/><EventID>101</EventID><Version>0</Version><Level>2</Level><Task>101</Task><Opcode>101</Opcode><Keywords>0x8000000000000001</Keywords><TimeCreated SystemTime='2025-04-08T12:57:44.3822508Z'/><EventRecordID>2340923</EventRecordID><Correlation/><Execution ProcessID='1496' ThreadID='9628'/><Channel>Microsoft-Windows-TaskScheduler/Operational</Channel><Computer>appcompl04d.its.corp.gwl.com</Computer><Security UserID='S-1-5-18'/></System><EventData Name='TaskStartFailedEvent'><Data Name='TaskName'>\FailingTask</Data><Data Name='UserContext'>IND\chnksv</Data><Data Name='ResultCode'>2147942402</Data></EventData><RenderingInfo Culture='en-US'><Message>Task Scheduler failed to start "\FailingTask" task for user "IND\chnksv". Additional Data: Error Value: 2147942402.</Message><Level>Error</Level><Task>Task Start Failed</Task><Opcode>Launch Failure</Opcode><Channel>Operational</Channel><Provider>Microsoft-Windows-TaskScheduler</Provider><Keywords></Keywords></RenderingInfo></Event>
<Event xmlns='http://schemas.microsoft.com/win/2004/08/events/event'><System><Provider Name='Microsoft-Windows-TaskScheduler' Guid='{de7b24ea-73c8-4a09-985d-5bdadcfa9017}'/><EventID>203</EventID><Version>0</Version><Level>2</Level><Task>203</Task><Opcode>101</Opcode><Keywords>0x8000000000000000</Keywords><TimeCreated SystemTime='2025-04-08T12:57:48.3814290Z'/><EventRecordID>2340925</EventRecordID><Correlation ActivityID='{ef96c812-979f-497d-a0ec-02b2d13ed27f}'/><Execution ProcessID='1496' ThreadID='9628'/><Channel>Microsoft-Windows-TaskScheduler/Operational</Channel><Computer>appcompl04d.its.corp.gwl.com</Computer><Security UserID='S-1-5-18'/></System><EventData Name='ActionLaunchFailure'><Data Name='TaskName'>\FailingTask</Data><Data Name='TaskInstanceId'>{ef96c812-979f-497d-a0ec-02b2d13ed27f}</Data><Data Name='ActionName'>c:\DoestNotExist\fail.exe</Data><Data Name='ResultCode'>2147942402</Data></EventData><RenderingInfo Culture='en-US'><Message>Task Scheduler failed to launch action "c:\DoestNotExist\fail.exe" in instance "{ef96c812-979f-497d-a0ec-02b2d13ed27f}" of task "\FailingTask". Additional Data: Error Value: 2147942402.</Message><Level>Error</Level><Task>Action failed to start</Task><Opcode>Launch Failure</Opcode><Channel>Operational</Channel><Provider>Microsoft-Windows-TaskScheduler</Provider><Keywords></Keywords></RenderingInfo></Event>
<Event xmlns='http://schemas.microsoft.com/win/2004/08/events/event'><System><Provider Name='Microsoft-Windows-TaskScheduler' Guid='{de7b24ea-73c8-4a09-985d-5bdadcfa9017}'/><EventID>101</EventID><Version>0</Version><Level>2</Level><Task>101</Task><Opcode>101</Opcode><Keywords>0x8000000000000001</Keywords><TimeCreated SystemTime='2025-04-08T12:57:48.3816120Z'/><EventRecordID>2340926</EventRecordID><Correlation/><Execution ProcessID='1496' ThreadID='9628'/><Channel>Microsoft-Windows-TaskScheduler/Operational</Channel><Computer>appcompl04d.its.corp.gwl.com</Computer><Security UserID='S-1-5-18'/></System><EventData Name='TaskStartFailedEvent'><Data Name='TaskName'>\FailingTask</Data><Data Name='UserContext'>IND\chnksv</Data><Data Name='ResultCode'>2147942402</Data></EventData><RenderingInfo Culture='en-US'><Message>Task Scheduler failed to start "\FailingTask" task for user "IND\chnksv". Additional Data: Error Value: 2147942402.</Message><Level>Error</Level><Task>Task Start Failed</Task><Opcode>Launch Failure</Opcode><Channel>Operational</Channel><Provider>Microsoft-Windows-TaskScheduler</Provider><Keywords></Keywords></RenderingInfo></Event>
<Event xmlns='http://schemas.microsoft.com/win/2004/08/events/event'><System><Provider Name='Microsoft-Windows-TaskScheduler' Guid='{de7b24ea-73c8-4a09-985d-5bdadcfa9017}'/><EventID>202</EventID><Version>1</Version><Level>2</Level><Task>202</Task><Opcode>102</Opcode><Keywords>0x8000000000000000</Keywords><TimeCreated SystemTime='2025-04-08T13:04:46.4516901Z'/><EventRecordID>2340943</EventRecordID><Correlation ActivityID='{983fe160-6313-47be-ae5e-e69ab7e67dff}'/><Execution ProcessID='1496' ThreadID='10036'/><Channel>Microsoft-Windows-TaskScheduler/Operational</Channel><Computer>appcompl04d.its.corp.gwl.com</Computer><Security UserID='S-1-5-18'/></System><EventData Name='ActionFailure'><Data Name='TaskName'>\Microsoft\Windows\CertificateServicesClient\KeyPreGenTask</Data><Data Name='TaskInstanceId'>{983fe160-6313-47be-ae5e-e69ab7e67dff}</Data><Data Name='ActionName'>NGC Pregeneration Task Handler</Data><Data Name='ResultCode'>2148073520</Data><Data Name='EnginePID'>11144</Data></EventData><RenderingInfo Culture='en-US'><Message>Task Scheduler failed to complete task "\Microsoft\Windows\CertificateServicesClient\KeyPreGenTask" , instance "{983fe160-6313-47be-ae5e-e69ab7e67dff}" , action "NGC Pregeneration Task Handler" . Additional Data: Error Value: 2148073520.</Message><Level>Error</Level><Task>Action failed</Task><Opcode>Run Failure</Opcode><Channel>Operational</Channel><Provider>Microsoft-Windows-TaskScheduler</Provider><Keywords></Keywords></RenderingInfo></Event>
<Event xmlns='http://schemas.microsoft.com/win/2004/08/events/event'><System><Provider Name='Microsoft-Windows-TaskScheduler' Guid='{de7b24ea-73c8-4a09-985d-5bdadcfa9017}'/><EventID>103</EventID><Version>0</Version><Level>2</Level><Task>103</Task><Opcode>102</Opcode><Keywords>0x8000000000000001</Keywords><TimeCreated SystemTime='2025-04-08T13:04:46.4516920Z'/><EventRecordID>2340944</EventRecordID><Correlation ActivityID='{983fe160-6313-47be-ae5e-e69ab7e67dff}'/><Execution ProcessID='1496' ThreadID='10036'/><Channel>Microsoft-Windows-TaskScheduler/Operational</Channel><Computer>appcompl04d.its.corp.gwl.com</Computer><Security UserID='S-1-5-18'/></System><EventData Name='TaskFailureEvent'><Data Name='TaskName'>\Microsoft\Windows\CertificateServicesClient\KeyPreGenTask</Data><Data Name='InstanceId'>{983fe160-6313-47be-ae5e-e69ab7e67dff}</Data><Data Name='UserContext'>NT AUTHORITY\SYSTEM</Data><Data Name='ResultCode'>2148073520</Data></EventData><RenderingInfo Culture='en-US'><Message>Task Scheduler failed to start instance "{983fe160-6313-47be-ae5e-e69ab7e67dff}" of "\Microsoft\Windows\CertificateServicesClient\KeyPreGenTask"  task for user "NT AUTHORITY\SYSTEM" . Additional Data: Error Value: 2148073520.</Message><Level>Error</Level><Task>Action start failed</Task><Opcode>Run Failure</Opcode><Channel>Operational</Channel><Provider>Microsoft-Windows-TaskScheduler</Provider><Keywords></Keywords></RenderingInfo></Event>



TaskSchedulerErrorWarning
Filter pattern
?ERROR ?Warning
Metric
TaskMonitor  / TaskSchedularErrors 
Metric value
1
Default value
-
Applied on transformed logs
-
Unit
-
Dimensions
-
Alarms
None.


<Event xmlns='http://schemas.microsoft.com/win/2004/08/events/event'><System><Provider Name='Microsoft-Windows-TaskScheduler' Guid='{de7b24ea-73c8-4a09-985d-5bdadcfa9017}'/><EventID>101</EventID><Version>0</Version><Level>2</Level><Task>101</Task><Opcode>101</Opcode><Keywords>0x8000000000000001</Keywords><TimeCreated SystemTime='2025-04-08T12:14:34.3304118Z'/><EventRecordID>2340822</EventRecordID><Correlation/><Execution ProcessID='1496' ThreadID='8832'/><Channel>Microsoft-Windows-TaskScheduler/Operational</Channel><Computer>appcompl04d.its.corp.gwl.com</Computer><Security UserID='S-1-5-18'/></System><EventData Name='TaskStartFailedEvent'><Data Name='TaskName'>\FailingTask</Data><Data Name='UserContext'>IND\chnksv</Data><Data Name='ResultCode'>2147942402</Data></EventData><RenderingInfo Culture='en-US'><Message>Task Scheduler failed to start "\FailingTask" task for user "IND\chnksv". Additional Data: Error Value: 2147942402.</Message><Level>Error</Level><Task>Task Start Failed</Task><Opcode>Launch Failure</Opcode><Channel>Operational</Channel><Provider>Microsoft-Windows-TaskScheduler</Provider><Keywords></Keywords></RenderingInfo></Event>


{
  "logs": {
    "logs_collected": {
      "windows_events": {
        "collect_list": [
          {
            "event_name": "Application",
            "event_levels": ["ERROR", "WARNING"],
            "log_group_name": "EventViewer-Application",
            "log_stream_name": "{instance_id}"
          },
          {
            "event_name": "System",
            "event_levels": ["ERROR", "WARNING"],
            "log_group_name": "EventViewer-System",
            "log_stream_name": "{instance_id}"
          },
          {
            "event_name": "Microsoft-Windows-TaskScheduler/Operational",
            "event_levels": ["ERROR", "WARNING"],
            "log_group_name": "TaskScheduler-Logs",
            "log_stream_name": "{instance_id}"
          }
        ]
      }
    }
  }
}



****** processing amazon-cloudwatch-agent ******
I! Trying to detect region from ec2
D! [EC2] Found active network interface
I! imds retry client will retry 1 timesSuccessfully fetched the config and saved in C:\ProgramData\Amazon\AmazonCloudWatchAgent\Configs\file_config.json.tmp
Start configuration validation...
2025/04/08 05:31:36 Reading json config file path: C:\ProgramData\Amazon\AmazonCloudWatchAgent\Configs\file_config.json.tmp ...
2025/04/08 05:31:36 I! Valid Json input schema.
I! Trying to detect region from ec2
D! [EC2] Found active network interface
I! imds retry client will retry 1 times2025/04/08 05:31:36 Configuration validation first phase succeeded
Configuration validation second phase succeeded
Configuration validation succeeded
AmazonCloudWatchAgent has been stopped
AmazonCloudWatchAgent has been started
PS C:\Program Files\Amazon\AmazonCloudWa


{
  "logs": {
    "logs_collected": {
      "windows_events": {
        "collect_list": [
          {
            "event_name": "Application",
            "event_levels": ["ERROR", "WARNING"],
            "log_group_name": "EventViewer-Application",
            "log_stream_name": "{instance_id}"
          },
          {
            "event_name": "System",
            "event_levels": ["ERROR", "WARNING"],
            "log_group_name": "EventViewer-System",
            "log_stream_name": "{instance_id}"
          }
        ]
      }
    }
  }
}




 cd "C:\Program Files\Amazon\AmazonCloudWatchAgent"
>> .\amazon-cloudwatch-agent-ctl.ps1 -a fetch-config -m ec2 -c file:"C:\Program Files\Amazon\AmazonCloudWatchAgent\config.json" -s
>> C:\Program Files\Amazon\AmazonCloudWatchAgent>
****** processing amazon-cloudwatch-agent ******
I! Trying to detect region from ec2
D! [EC2] Found active network interface
I! imds retry client will retry 1 timesSuccessfully fetched the config and saved in C:\ProgramData\Amazon\AmazonCloudWatchAgent\Configs\file_config.json.tmp
Start configuration validation...
2025/04/08 05:28:39 Reading json config file path: C:\ProgramData\Amazon\AmazonCloudWatchAgent\Configs\file_config.json.tmp ...
2025/04/08 05:28:39 E! Invalid Json input schema.
2025/04/08 05:28:39 E! Invalid Json input schema.
2025/04/08 05:28:39 Under path : /logs | Error : Must validate at least one schema (anyOf)
2025/04/08 05:28:39 Under path : /logs | Error : logs_collected is required
2025/04/08 05:28:39 Under path : /logs | Error : Additional property windows_events is not allowed
2025/04/08 05:28:39 Configuration validation first phase failed. Agent version: 1.0. Verify the JSON input is only using features supported by this version.
PS C:\Program Files\Amazon\Amazon



>>
****** processing amazon-cloudwatch-agent ******
I! Trying to detect region from ec2
D! [EC2] Found active network interface
I! imds retry client will retry 1 times2025/04/08 05:19:44 E! Fail to fetch/remove json config: open C:\Program Files\Amazon\AmazonCloudWatchAgent\config.json: The system cannot find the file specified.
E! Fail to fetch/remove json config: open C:\Program Files\Amazon\AmazonCloudWatchAgent\config.json: The system cannot find the file specified.
Fail to fetch the config!
PS C:\Program Files\Amazon\AmazonCloudWatchAgent>


cd "C:\Program Files\Amazon\AmazonCloudWatchAgent"
.\amazon-cloudwatch-agent-ctl.ps1 -a fetch-config -m ec2 -c file:"C:\Program Files\Amazon\AmazonCloudWatchAgent\config.json" -s



{
  "logs": {
    "windows_events": [
      {
        "event_name": "Application",
        "event_levels": ["ERROR", "WARNING"],
        "log_group_name": "EventViewer-Application",
        "log_stream_name": "{instance_id}"
      },
      {
        "event_name": "System",
        "event_levels": ["ERROR", "WARNING"],
        "log_group_name": "EventViewer-System",
        "log_stream_name": "{instance_id}"
      }
    ]
  }
}



C:\Program Files\Amazon\AmazonCloudWatchAgent\config.json


cd "C:\Temp\CWAgent"
.\install.ps1


Expand-Archive -Path "C:\Temp\AmazonCloudWatchAgent.zip" -DestinationPath "C:\Temp\CWAgent"


Invoke-WebRequest https://s3.amazonaws.com/amazoncloudwatch-agent/windows/amd64/latest/AmazonCloudWatchAgent.zip -OutFile "C:\Temp\AmazonCloudWatchAgent.zip"


import com.ecm1.ECM1.controller.ECMcontroller;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class FileSelectorGUI {
    private final ECMcontroller mcontroller;
    private final JPanel mainPanel, postPanel, deletePanel, buttonPanel;
    private final JTextField txtWorkingDir, txtExcelFile, txtInputDir, txtOutputReport, txtOutputDir, txtDeleteId;
    private final JButton btnRunPost, btnRunDelete;

    public FileSelectorGUI(ECMcontroller mcontroller) {
        this.mcontroller = mcontroller;

        // Create Frame
        JFrame frame = new JFrame("ECM File Selector");
        frame.setSize(550, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // ** Card Layout to Switch Between Panels **
        CardLayout cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // ** Post Panel **
        postPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        postPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JButton btnWorkingDir = new JButton("Select Working Dir");
        JButton btnExcelFile = new JButton("Select Excel File");
        JButton btnInputDir = new JButton("Select Input Dir");
        JButton btnOutputReport = new JButton("Select Report File");
        JButton btnOutputDir = new JButton("Select Output Dir");
        btnRunPost = new JButton("Run Post");

        txtWorkingDir = createTextField();
        txtExcelFile = createTextField();
        txtInputDir = createTextField();
        txtOutputReport = createTextField();
        txtOutputDir = createTextField();

        btnWorkingDir.addActionListener(e -> selectDirectory("Select Working Directory", txtWorkingDir));
        btnExcelFile.addActionListener(e -> selectFile("Select Excel File", txtExcelFile));
        btnInputDir.addActionListener(e -> selectDirectory("Select Input Directory", txtInputDir));
        btnOutputReport.addActionListener(e -> selectFile("Select Output Report File", txtOutputReport));
        btnOutputDir.addActionListener(e -> selectDirectory("Select Output Directory", txtOutputDir));
        btnRunPost.addActionListener(e -> runProcessing());

        postPanel.add(btnWorkingDir); postPanel.add(txtWorkingDir);
        postPanel.add(btnExcelFile); postPanel.add(txtExcelFile);
        postPanel.add(btnInputDir); postPanel.add(txtInputDir);
        postPanel.add(btnOutputReport); postPanel.add(txtOutputReport);
        postPanel.add(btnOutputDir); postPanel.add(txtOutputDir);
        postPanel.add(new JLabel()); postPanel.add(btnRunPost);

        // ** Delete Panel **
        deletePanel = new JPanel(new GridLayout(2, 2, 10, 10));
        deletePanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JLabel lblDeleteId = new JLabel("Enter ID to Delete:");
        txtDeleteId = createTextField();
        btnRunDelete = new JButton("Run Delete");
        btnRunDelete.addActionListener(e -> runDelete());

        deletePanel.add(lblDeleteId);
        deletePanel.add(txtDeleteId);
        deletePanel.add(new JLabel());
        deletePanel.add(btnRunDelete);

        // ** Button Panel (Post/Delete) **
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        JButton btnPost = new JButton("Post");
        JButton btnDelete = new JButton("Delete");

        btnPost.setPreferredSize(new Dimension(150, 40));
        btnDelete.setPreferredSize(new Dimension(150, 40));

        btnPost.addActionListener(e -> cardLayout.show(mainPanel, "Post"));
        btnDelete.addActionListener(e -> cardLayout.show(mainPanel, "Delete"));

        buttonPanel.add(btnPost);
        buttonPanel.add(btnDelete);

        // Add to main layout
        mainPanel.add(new JPanel(), "Empty"); // Placeholder
        mainPanel.add(postPanel, "Post");
        mainPanel.add(deletePanel, "Delete");

        frame.add(buttonPanel, BorderLayout.NORTH);
        frame.add(mainPanel, BorderLayout.CENTER);
        cardLayout.show(mainPanel, "Empty");

        frame.setVisible(true);
    }

    // Helper method to create text fields
    private JTextField createTextField() {
        JTextField textField = new JTextField();
        textField.setEditable(false);
        textField.setPreferredSize(new Dimension(200, 25));
        return textField;
    }

    private void selectFile(String title, JTextField textField) {
        JFileChooser fileChooser = new JFileChooser(new File("C:\\"));
        fileChooser.setDialogTitle(title);
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            textField.setText(fileChooser.getSelectedFile().getAbsolutePath());
        }
    }

    private void selectDirectory(String title, JTextField textField) {
        JFileChooser directoryChooser = new JFileChooser(new File("C:\\"));
        directoryChooser.setDialogTitle(title);
        directoryChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnValue = directoryChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            textField.setText(directoryChooser.getSelectedFile().getAbsolutePath());
        }
    }

    private void runProcessing() {
        if (txtExcelFile.getText().isEmpty() || txtInputDir.getText().isEmpty() || txtOutputDir.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please select all required fields!", "Missing Inputs", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String result = mcontroller.processFiles(txtExcelFile.getText(), txtInputDir.getText(), txtOutputDir.getText());
        JOptionPane.showMessageDialog(null, result, "Process Complete", JOptionPane.INFORMATION_MESSAGE);
    }

    private void runDelete() {
        String deleteId = txtDeleteId.getText().trim();
        if (deleteId.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter an ID!", "Missing ID", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String result = mcontroller.deleteFile(deleteId);
        JOptionPane.showMessageDialog(null, result, "Delete Complete", JOptionPane.INFORMATION_MESSAGE);
    }
}




import com.ecm1.ECM1.controller.ECMcontroller;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class FileSelectorGUI {
    private final FileSelectionData fileData;
    private final ECMcontroller mcontroller;
    private final JTextField txtWorkingDir, txtExcelFile, txtInputDir, txtOutputReport, txtOutputDir, txtDeleteId;
    private final JButton btnPost, btnDelete, btnRunPost, btnRunDelete;
    private final JPanel postPanel, deletePanel;

    public FileSelectorGUI(ECMcontroller mcontroller) {
        this.mcontroller = mcontroller;
        this.fileData = new FileSelectionData();

        // Create frame
        JFrame frame = new JFrame("ECM File Selector");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Main selection panel (Post/Delete)
        JPanel selectionPanel = new JPanel();
        btnPost = new JButton("Post");
        btnDelete = new JButton("Delete");
        selectionPanel.add(btnPost);
        selectionPanel.add(btnDelete);

        // Post Panel
        postPanel = new JPanel();
        postPanel.setLayout(new GridLayout(6, 2, 10, 10));
        postPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JButton btnWorkingDir = new JButton("Select Working Dir");
        JButton btnExcelFile = new JButton("Select Excel File");
        JButton btnInputDir = new JButton("Select Input Dir");
        JButton btnOutputReport = new JButton("Select Report File");
        JButton btnOutputDir = new JButton("Select Output Dir");
        btnRunPost = new JButton("Run Post");

        txtWorkingDir = createTextField();
        txtExcelFile = createTextField();
        txtInputDir = createTextField();
        txtOutputReport = createTextField();
        txtOutputDir = createTextField();

        btnWorkingDir.addActionListener(e -> selectDirectory("Select Working Directory", txtWorkingDir));
        btnExcelFile.addActionListener(e -> selectFile("Select Excel File", txtExcelFile));
        btnInputDir.addActionListener(e -> selectDirectory("Select Input Directory", txtInputDir));
        btnOutputReport.addActionListener(e -> selectFile("Select Output Report File", txtOutputReport));
        btnOutputDir.addActionListener(e -> selectDirectory("Select Output Directory", txtOutputDir));
        btnRunPost.addActionListener(e -> runProcessing());

        postPanel.add(btnWorkingDir);
        postPanel.add(txtWorkingDir);
        postPanel.add(btnExcelFile);
        postPanel.add(txtExcelFile);
        postPanel.add(btnInputDir);
        postPanel.add(txtInputDir);
        postPanel.add(btnOutputReport);
        postPanel.add(txtOutputReport);
        postPanel.add(btnOutputDir);
        postPanel.add(txtOutputDir);
        postPanel.add(new JLabel()); // Empty cell
        postPanel.add(btnRunPost);

        // Delete Panel
        deletePanel = new JPanel();
        deletePanel.setLayout(new GridLayout(2, 2, 10, 10));
        deletePanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JLabel lblDeleteId = new JLabel("Enter ID to Delete:");
        txtDeleteId = createTextField();
        btnRunDelete = new JButton("Run Delete");
        btnRunDelete.addActionListener(e -> runDelete());

        deletePanel.add(lblDeleteId);
        deletePanel.add(txtDeleteId);
        deletePanel.add(new JLabel()); // Empty cell
        deletePanel.add(btnRunDelete);

        // Initially hide both panels
        postPanel.setVisible(false);
        deletePanel.setVisible(false);

        // Button actions
        btnPost.addActionListener(e -> {
            postPanel.setVisible(true);
            deletePanel.setVisible(false);
        });

        btnDelete.addActionListener(e -> {
            deletePanel.setVisible(true);
            postPanel.setVisible(false);
        });

        // Main layout
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(selectionPanel, BorderLayout.NORTH);
        mainPanel.add(postPanel, BorderLayout.CENTER);
        mainPanel.add(deletePanel, BorderLayout.CENTER);

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    // Creates a text field for displaying selected file paths
    private JTextField createTextField() {
        JTextField textField = new JTextField();
        textField.setEditable(false);
        return textField;
    }

    private void selectFile(String title, JTextField textField) {
        JFileChooser fileChooser = new JFileChooser(new File("C:\\")); // Default to C:\ drive
        fileChooser.setDialogTitle(title);
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            textField.setText(fileChooser.getSelectedFile().getAbsolutePath());
        }
    }

    private void selectDirectory(String title, JTextField textField) {
        JFileChooser directoryChooser = new JFileChooser(new File("C:\\")); // Default to C:\ drive
        directoryChooser.setDialogTitle(title);
        directoryChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnValue = directoryChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            textField.setText(directoryChooser.getSelectedFile().getAbsolutePath());
        }
    }

    private void runProcessing() {
        fileData.setInputWorkingDir(txtWorkingDir.getText());
        fileData.setInputExcelFile(txtExcelFile.getText());
        fileData.setInputAllDir(txtInputDir.getText());
        fileData.setOutputReportFile(txtOutputReport.getText());
        fileData.setOutputDir(txtOutputDir.getText());

        if (!fileData.areAllFieldsSet()) {
            JOptionPane.showMessageDialog(null, "Error: Please select all required fields!", "Missing Inputs", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String result = mcontroller.processFiles(fileData.getInputExcelFile(), fileData.getInputAllDir(), fileData.getOutputDir());
        JOptionPane.showMessageDialog(null, result, "Process Complete", JOptionPane.INFORMATION_MESSAGE);
    }

    private void runDelete() {
        String deleteId = txtDeleteId.getText().trim();
        if (deleteId.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error: Please enter an ID!", "Missing ID", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String result = mcontroller.deleteFile(deleteId);
        JOptionPane.showMessageDialog(null, result, "Delete Complete", JOptionPane.INFORMATION_MESSAGE);
    }
}




package com.ecm1.ECM1.ui;

import com.ecm1.ECM1.controller.ECMcontroller;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class FileSelectorGUI {
    private final FileSelectionData fileData;
    private final ECMcontroller mcontroller;
    private final JFrame frame;
    private final JPanel mainPanel, postPanel, deletePanel;
    private final JTextField txtWorkingDir, txtExcelFile, txtInputDir, txtOutputReport, txtOutputDir, txtDeleteId;

    public FileSelectorGUI(ECMcontroller mcontroller) {
        this.mcontroller = mcontroller;
        this.fileData = new FileSelectionData();

        frame = new JFrame("ECM File Selector");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        mainPanel = new JPanel();
        postPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        deletePanel = new JPanel(new GridLayout(2, 2, 10, 10));
        
        showMainPanel();
        frame.setVisible(true);
    }

    private void showMainPanel() {
        mainPanel.removeAll();
        JButton btnPost = new JButton("Post");
        JButton btnDelete = new JButton("Delete");

        btnPost.addActionListener(e -> showPostPanel());
        btnDelete.addActionListener(e -> showDeletePanel());

        mainPanel.add(btnPost);
        mainPanel.add(btnDelete);

        frame.add(mainPanel, BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();
    }

    private void showPostPanel() {
        postPanel.removeAll();

        JButton btnWorkingDir = new JButton("Select Working Dir");
        JButton btnExcelFile = new JButton("Select Excel File");
        JButton btnInputDir = new JButton("Select Input Dir");
        JButton btnOutputReport = new JButton("Select Report File");
        JButton btnOutputDir = new JButton("Select Output Dir");
        JButton btnSubmit = new JButton("Submit");
        JButton btnBack = new JButton("Back");

        txtWorkingDir = createTextField();
        txtExcelFile = createTextField();
        txtInputDir = createTextField();
        txtOutputReport = createTextField();
        txtOutputDir = createTextField();

        btnWorkingDir.addActionListener(e -> selectDirectory("Select Working Directory", txtWorkingDir));
        btnExcelFile.addActionListener(e -> selectFile("Select Excel File", txtExcelFile));
        btnInputDir.addActionListener(e -> selectDirectory("Select Input Directory", txtInputDir));
        btnOutputReport.addActionListener(e -> selectFile("Select Output Report File", txtOutputReport));
        btnOutputDir.addActionListener(e -> selectDirectory("Select Output Directory", txtOutputDir));
        btnSubmit.addActionListener(e -> runProcessing());
        btnBack.addActionListener(e -> showMainPanel());

        postPanel.add(btnWorkingDir); postPanel.add(txtWorkingDir);
        postPanel.add(btnExcelFile); postPanel.add(txtExcelFile);
        postPanel.add(btnInputDir); postPanel.add(txtInputDir);
        postPanel.add(btnOutputReport); postPanel.add(txtOutputReport);
        postPanel.add(btnOutputDir); postPanel.add(txtOutputDir);
        postPanel.add(btnSubmit);
        postPanel.add(btnBack);

        frame.add(postPanel, BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();
    }

    private void showDeletePanel() {
        deletePanel.removeAll();

        JLabel lblDeleteId = new JLabel("Enter ID:");
        txtDeleteId = createTextField();
        JButton btnDelete = new JButton("Delete");
        JButton btnBack = new JButton("Back");

        btnDelete.addActionListener(e -> deleteRecord());
        btnBack.addActionListener(e -> showMainPanel());

        deletePanel.add(lblDeleteId);
        deletePanel.add(txtDeleteId);
        deletePanel.add(btnDelete);
        deletePanel.add(btnBack);

        frame.add(deletePanel, BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();
    }

    private JTextField createTextField() {
        JTextField textField = new JTextField();
        textField.setEditable(false);
        return textField;
    }

    private void selectFile(String title, JTextField textField) {
        JFileChooser fileChooser = new JFileChooser("C:\");
        fileChooser.setDialogTitle(title);
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            textField.setText(fileChooser.getSelectedFile().getAbsolutePath());
        }
    }

    private void selectDirectory(String title, JTextField textField) {
        JFileChooser directoryChooser = new JFileChooser("C:\");
        directoryChooser.setDialogTitle(title);
        directoryChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnValue = directoryChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            textField.setText(directoryChooser.getSelectedFile().getAbsolutePath());
        }
    }

    private void runProcessing() {
        fileData.setInputWorkingDir(txtWorkingDir.getText());
        fileData.setInputExcelFile(txtExcelFile.getText());
        fileData.setInputAllDir(txtInputDir.getText());
        fileData.setOutputReportFile(txtOutputReport.getText());
        fileData.setOutputDir(txtOutputDir.getText());

        if (!fileData.areAllFieldsSet()) {
            JOptionPane.showMessageDialog(null, "Error: Please select all required fields!", "Missing Inputs", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String result = mcontroller.processFiles(fileData.getInputExcelFile(), fileData.getInputAllDir(), fileData.getOutputDir());
        JOptionPane.showMessageDialog(null, result, "Process Complete", JOptionPane.INFORMATION_MESSAGE);
    }

    private void deleteRecord() {
        String id = txtDeleteId.getText();
        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error: Please enter an ID!", "Missing Input", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String result = mcontroller.deleteRecord(id);
        JOptionPane.showMessageDialog(null, result, "Delete Status", JOptionPane.INFORMATION_MESSAGE);
    }
}



package com.ecm1.ECM1.ui;

import com.ecm1.ECM1.controller.ECMcontroller;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class FileSelectorGUI {
    private final FileSelectionData fileData;
    private final ECMcontroller mcontroller;
    private final JTextField txtWorkingDir, txtExcelFile, txtInputDir, txtOutputReport, txtOutputDir;

    public FileSelectorGUI(ECMcontroller mcontroller) {
        this.mcontroller = mcontroller;
        this.fileData = new FileSelectionData();

        // Create frame
        JFrame frame = new JFrame("ECM File Selector");
        frame.setSize(500, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Main panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2, 10, 10)); // Rows, Cols, Hgap, Vgap
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15)); // Padding

        // Create components
        JButton btnWorkingDir = new JButton("Select Working Dir");
        JButton btnExcelFile = new JButton("Select Excel File");
        JButton btnInputDir = new JButton("Select Input Dir");
        JButton btnOutputReport = new JButton("Select Report File");
        JButton btnOutputDir = new JButton("Select Output Dir");
        JButton btnRun = new JButton("Run");

        // Text fields to display selected paths
        txtWorkingDir = createTextField();
        txtExcelFile = createTextField();
        txtInputDir = createTextField();
        txtOutputReport = createTextField();
        txtOutputDir = createTextField();

        // Action listeners
        btnWorkingDir.addActionListener(e -> selectDirectory("Select Working Directory", txtWorkingDir));
        btnExcelFile.addActionListener(e -> selectFile("Select Excel File", txtExcelFile));
        btnInputDir.addActionListener(e -> selectDirectory("Select Input Directory", txtInputDir));
        btnOutputReport.addActionListener(e -> selectFile("Select Output Report File", txtOutputReport));
        btnOutputDir.addActionListener(e -> selectDirectory("Select Output Directory", txtOutputDir));
        btnRun.addActionListener(e -> runProcessing());

        // Add components to panel
        panel.add(btnWorkingDir);
        panel.add(txtWorkingDir);
        panel.add(btnExcelFile);
        panel.add(txtExcelFile);
        panel.add(btnInputDir);
        panel.add(txtInputDir);
        panel.add(btnOutputReport);
        panel.add(txtOutputReport);
        panel.add(btnOutputDir);
        panel.add(txtOutputDir);

        // Button Panel for Run Button (centered)
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnRun);

        // Add panels to frame
        frame.add(panel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    // Creates a text field for displaying selected file paths
    private JTextField createTextField() {
        JTextField textField = new JTextField();
        textField.setEditable(false);
        return textField;
    }

    // Handles file selection with Working Directory as base
    private void selectFile(String title, JTextField textField) {
        JFileChooser fileChooser = new JFileChooser();

        // Set base directory if Working Directory is selected
        if (!txtWorkingDir.getText().isEmpty()) {
            fileChooser.setCurrentDirectory(new File(txtWorkingDir.getText()));
        }

        fileChooser.setDialogTitle(title);
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            String filePath = fileChooser.getSelectedFile().getAbsolutePath();
            textField.setText(filePath);
        }
    }

    // Handles directory selection with Working Directory as base
    private void selectDirectory(String title, JTextField textField) {
        JFileChooser directoryChooser = new JFileChooser();

        // Set base directory if Working Directory is selected
        if (!txtWorkingDir.getText().isEmpty()) {
            directoryChooser.setCurrentDirectory(new File(txtWorkingDir.getText()));
        }

        directoryChooser.setDialogTitle(title);
        directoryChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnValue = directoryChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            String dirPath = directoryChooser.getSelectedFile().getAbsolutePath();
            textField.setText(dirPath);
        }
    }

    // Runs the processing logic
    private void runProcessing() {
        fileData.setInputWorkingDir(txtWorkingDir.getText());
        fileData.setInputExcelFile(txtExcelFile.getText());
        fileData.setInputAllDir(txtInputDir.getText());
        fileData.setOutputReportFile(txtOutputReport.getText());
        fileData.setOutputDir(txtOutputDir.getText());

        // Debugging: Print stored values
        System.out.println("Running process with:");
        System.out.println("Working Dir: " + fileData.getInputWorkingDir());
        System.out.println("Excel File: " + fileData.getInputExcelFile());
        System.out.println("Input Directory: " + fileData.getInputAllDir());
        System.out.println("Output Report File: " + fileData.getOutputReportFile());
        System.out.println("Output Directory: " + fileData.getOutputDir());

        if (!fileData.areAllFieldsSet()) {
            JOptionPane.showMessageDialog(null, "Error: Please select all required fields!", "Missing Inputs", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Call controller method
        String result = mcontroller.processFiles(fileData.getInputExcelFile(), fileData.getInputAllDir(), fileData.getOutputDir());

        JOptionPane.showMessageDialog(null, result, "Process Complete", JOptionPane.INFORMATION_MESSAGE);
    }
}




PS C:\compliance1\ECM1> mvn clean package
mvn : The term 'mvn' is not recognized as the name of a cmdlet, function, script file, or operable program. Check 
the spelling of the name, or if a path was included, verify that the path is correct and try again.
At line:1 char:1
+ mvn clean package
+ ~~~
    + CategoryInfo          : ObjectNotFound: (mvn:String) [], CommandNotFoundException
    + FullyQualifiedErrorId : CommandNotFoundException

PS C:\compliance1\ECM1> 



spackage com.example.firstt;

import org.springframework.data.jpa.repository.JpaRepository;

public interface repo extends JpaRepository<PlanInfo, String>{

}
