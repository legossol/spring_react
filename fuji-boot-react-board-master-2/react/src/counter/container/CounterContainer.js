import { ReduxCounter } from 'counter'
import React, { useCallback } from 'react'
import { Counter } from 'counter/index'
import { useSelector , useDispatch } from 'react-redux'
import { increase, decrease } from 'counter/reducer/counter.reducer'

const CounterContainer = () => {
                    //useSelector는 속성은 가져오는 것
    const number = useSelector(state => (state.counterReducer.number))
    
    const dispatch = useDispatch()
                    //usecallback은 기능을 가져오는것
    const onIncrease = useCallback(()=> dispatch(increase()),[dispatch])
                                        
                                        //usecallback(안에는 함수가 와야한다ㅏ., )
    const onDecrease = useCallback(()=> dispatch(decrease()),[dispatch])
    return (<>
        <ReduxCounter number={number} onIncrease={onIncrease} onDecrease={onDecrease}/>
    </>)
}

export default CounterContainer
