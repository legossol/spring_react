import { ReduxCounter } from 'counter'
import React, { useCallback } from 'react'
import { Counter } from 'counter/index'
import { useSelector , useDispatch } from 'react-redux'
import { increase, decrease } from 'counter/reducer/counter.reducer'

const CounterSliceContainer = () => {
                    //useSelector는 속성은 가져오는 것
    
    const dispatch = useDispatch()
    const number = useSelector(state =>(state.counterSlice.number))
                    //usecallback은 기능을 가져오는것
    return (<>
        <ReduxCounter number={number}
        onIncrease={() =>dispatch(increase(1))} 
        onDecrease={() =>dispatch(decrease(1))}/>
    </>)
}

export default CounterSliceContainer