# 퍼셉트론에 대한 이해 
* 가중치[W] 입력 신호가 결과에 주는 영향력
* 편향[b] 퍼셉트론이 얼마나 쉽게 활성화 되는가를 조정하는 변수
* 활성함수 입력신호의 총합을 확인해 출력신호를 결정하는 함수

# 인공신경망에 대한 이해
* 단일 퍼셉트론을 여러층으로 쌓아서 만든 모델 DNN/MLP
* 입력층 
* 은닉층
* 출력층
* 기본적으로 3개의 레이어를 갖게됨

# **TensorFlow 2.0을 이용한 인공신경망 구현 실습**

## **TensorFlow 2.0 를 이용한 인공신경망 데이터 이해**

tf.constant(상수)
* 텐서플로우에 사용되는 텐서(데이터) 유형 중 하나
* 상수형 텐서로써 할당된 값의 변경이 불가
* Numpy의 ndarray 와 유사한 속성들을(ndim, shape, dtype) 가짐
* .numpy() 메서드를 통해 텐서에 들어 있는 데이터를 Numpy ndarray 형태로 가져옴

tf.Variable(변수)
* 텐서플로우에 사용되는 텐서(데이터) 유형 중 하나
* Numpy의 ndarray 와 유사한 속성들을(ndim(X), shape, dtype) 가짐
* tf.constant(상수) 와는 다르게 assign(value) 같은 메소드를 통해 할당된 값의 변경 가능
* .numpy() 메서드를 통해 텐서에 들어 있는 데이터를 Numpy ndarray 형태로 가져옴
* 인공신경망의 변수(가중치, 바이어스) 구성에 사용됨

## **TensorFlow 2.0 연산자 이해**
텐서플로우 수학연산
* Numpy에서 사용 되는 대부분의 수학 연산을 동일한 방법으로 사용 가능
* 텐서플로우 연산자 들은 TPU, GPU 와 같은 가속 하드웨어를 이용해 수행 가능

텐서플로우 연산의 미분
* 미분 가능한 연산들에 대해서 자동으로 미분계산
* GradientTape 컨텍스 내에서 .watch() 메서드를 통해 해당 텐서로 수행하는 연산에 대한 미분 확인(상수 텐서의 경우)

## **TensorFlow 2.0 을 이용한 퍼셉트론 구현** 
* 퍼셉트론 수학모델
```
def predict(input):
  x = tf.matmul(input,w) + b
  x = tf.maximum(0, x)
  return x
```

* loss(mse)함수
```
def mse_loss(labels, predictinos):
  loss = tf.reduce_mean(tf.square(labels - predictions))
  return loss
```

*  학습함수
```
def train(inputs, labels):
  with tf.GradientTape() as tape:
    predictions - predict(inputs)
    loss = mse_loss(labels, predictinos)
    gradient_lw, gradient_lb = tape.gradient(loss, [w,b])
  w.assign(w - learning_rate * gradient_lw)
  b.assign(b - learning_rate * gradient_lb)
  return loss
```

## **Keras API 의 기초 문법 및 개발 패턴 이해**
Keras 작업 흐름
1. 입력 텐서와 타깃텐서로 이루어진 훈련데이터를 정의  
2. 입력과 타깃을 매핑하는 층으로 이루어진 네트워크을 정의
3. 손실함수, 옵티마이저, 성능지표 선택하여 학습과정을 설정
4. 훈련데이터에 대해서 모델의 fit()메서드를 실행

-----------------------------
# **4강 이미지 처리와 CNN모델에 대한 이해**

## **이미지 처리와 딥러닝**
* 이미지 분석은 딥러닝이 가장 잘 적용되는 분야 중 하나.
* 2012년 이미지넷 대회에서 AlexNet이 획기적인 성능을 보임으로써 딥러닝이 주목을 받는 계기가 됨
* 현재 이미지 인식, 이미지 캡셔닝 등의 분야에서 인간 이상의 성능을 보여줌
// TODO AlexNet

* CNN (Convolutional Neural Network)
    * 1989년 얀쿤이 처음으로 제안 (5layer로 구성됨)
    * 발표 당시에 필기에 인식에 높은 성능을 보임. 
    * 2012년 CNN(8layer)의 구조를 GPU를 이용한 심층구조로 고도화한 AlexNet이 성능을 획기적으로 높임
    * 전통적인 CV알고리즘은 70%초반의 성능을 보였으나 AlexNet이 12%이상 개선함.

* CNN의 발전
    * 현재 ResNet은 인간의 인식률 95%보다 나은 97%를 보여주게됨.

* 이미지 분석 관련 서비스
    * 이미지의 분류 
    * 이미지의 분류와 좌표제공
    * Object Detection
    * Inatance Segmentation

## **CNN모델의 구조 이해** 
* DNN(Deep Neural Network) 와 같이 입력 계층, 출력 계층 그리고 두 계층 사이의 여러 개의 은니계층으로 구성
* CNN의 은닉계층은 특징 추출, 분류 분석 2개로 구성
* CNN의 은닉계층에서 데이터를 분석하는 순서
    1. 특징 추출: 특징 및 위치 정보를 추출
    2. 분류 분석 : 1.에서 추출된 정보를 이용해 데이터 분류 
* 특징 추출 계층
    * 입력 데이터의 특징을 위치정보와 함께 추출하기 위한 계층
    * convolution : 특징 추출에 사용되는 연산
    * Relu : 활성화 함수
    * Pooling : 데이터를 사이즈 줄이기 위한 Sub sampling전략
* 분류 계층
    * 특징 추출 계층에서 얻은 정보를 이용해 분류를 수행하는 계층
    * Flatten : 특정 추출 계층의 정보를 FCL에서 처리할 수 있는 형태로 가공
    * FCL (Fully Connected Layer) : 특징 추출 계층의 정보를 처리
    * Softmax : 분류 분석을 위한 활성화 함수

## **이미지 데이터에 대한 이해**
*  

## **

# **6강 텐서플로를 이용한 실전 CNN 모델 구현 실습**
## **Transfer Learning 에 대한 이해**
사전 학습된 CNN을 이용한 학습
* 작은 데이터셋에 딥러닝을 적용하는 가장 효과적인 방법은, 

* 새로운 데이터셋이 기존 모델이 훈련한 데이터셋과 많이 다르면 모델의 하위층 몇 개만 특성 추출에 사용하는 것이 좋음