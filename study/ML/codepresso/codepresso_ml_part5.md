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