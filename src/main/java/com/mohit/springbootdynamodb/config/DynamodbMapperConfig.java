package com.mohit.springbootdynamodb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

@Configuration
public class DynamodbMapperConfig {
	
	@Bean
	public DynamoDBMapper mapper() {
		return new DynamoDBMapper(amazonDynamoDB());
	}

	private AmazonDynamoDB amazonDynamoDB() {
		return AmazonDynamoDBClientBuilder.standard().
				withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("dynamodb.ap-south-1.amazonaws.com","ap-south-1")).
				withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials("provideAccessKey", "provideSecretKey"))).build();
	}

}
