//
//  WebSocketFragment.h
//  UnittWebSocketClient
//
//  Created by Josh Morris on 6/12/11.
//  Copyright 2011 UnitT Software. All rights reserved.
//
//  Licensed under the Apache License, Version 2.0 (the "License"); you may not
//  use this file except in compliance with the License. You may obtain a copy of
//  the License at
// 
//  http://www.apache.org/licenses/LICENSE-2.0
// 
//  Unless required by applicable law or agreed to in writing, software
//  distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
//  WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
//  License for the specific language governing permissions and limitations under
//  the License.
//

#import <Foundation/Foundation.h>


enum 
{
    MessageOpCodeIllegal = -1,
    MessageOpCodeContinuation = 0,
    MessageOpCodeText = 1,
    MessageOpCodeBinary = 2,
    MessageOpCodeClose = 8,
    MessageOpCodePing = 9,
    MessageOpCodePong = 10
};
typedef NSInteger MessageOpCode;

enum 
{
    PayloadTypeUnknown = 0,
    PayloadTypeText = 1,
    PayloadTypeBinary = 2
};
typedef NSInteger PayloadType;

enum 
{
    PayloadLengthIllegal = -1,
    PayloadLengthMinimum = 0,
    PayloadLengthShort = 1,
    PayloadLengthLong = 2
};
typedef NSInteger PayloadLength;


@interface WebSocketFragment : NSObject 
{
    BOOL finished;
    int mask;
    int payloadStart;
    int payloadLength;
    PayloadType payloadType;
    NSData* payloadData;
    MessageOpCode opCode;
    NSData* fragment;
    NSUInteger messageLength;
}

@property (nonatomic,assign) BOOL finished;
@property (nonatomic,readonly) BOOL hasMask;
@property (nonatomic,readonly) BOOL isControlFrame;
@property (nonatomic,readonly) BOOL isDataFrame;
@property (nonatomic,readonly) BOOL isValid;
@property (nonatomic,assign) int mask;
@property (nonatomic,assign) MessageOpCode opCode;
@property (nonatomic,retain) NSData* payloadData;
@property (nonatomic,assign) PayloadType payloadType;
@property (nonatomic,retain) NSData* fragment;
@property (nonatomic,readonly) NSUInteger messageLength;

+ (PayloadLength) getPayloadLengthFromHeader:(NSData*) aHeader;
+ (BOOL) getIsMaskedFromHeader:(NSData*) aHeader;
+ (MessageOpCode) getOpCodeFromHeader:(NSData*) aHeader;
+ (int) getHeaderLengthFromHeader:(NSData*) aHeader;

+ (id) fragmentWithOpCode:(MessageOpCode) aOpCode payload:(NSData*) aPayload;
+ (id) fragmentWithData:(NSData*) aData;
- (id) initWithOpCode:(MessageOpCode) aOpCode payload:(NSData*) aPayload;
- (id) initWithData:(NSData*) aData;

@end
